package jing.chao.springcloud.controller;

import jing.chao.springcloud.entity.CommonResult;
import jing.chao.springcloud.entity.Payment;
import jing.chao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import sun.rmi.server.LoaderHandler;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author isi
 * @date 2020/4/1 15:38
 */
@RequestMapping("/payment")
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****service****" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @PostMapping(value = "/create")
    public CommonResult<Integer> create(Payment payment) {
        int result = paymentService.create(payment);
        if (result >= 1) {
            return new CommonResult<Integer>().success(result);
        } else {
            return new CommonResult<Integer>().fail("系统异常");
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        payment.setSerial(serverPort);
        return new CommonResult<Payment>().success(payment);
    }

    @GetMapping("/lb")
    public String lb() {
        return serverPort;
    }

    @GetMapping("/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "1";
    }

}
