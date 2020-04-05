package jing.chao.springcloud.controller;

import jing.chao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @GetMapping("/hystrix/ok/{id}")
    public String paymentHystrixOK(@PathVariable("id") Long id) {
        return paymentService.paymentHystrixOK(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentHystrixTimeout(@PathVariable("id") Long id) {
        return paymentService.paymentHystrixTimeout(id);
    }

    @GetMapping("/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        return paymentService.paymentCircuitBreaker(id);
    }

}
