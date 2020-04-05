package jing.chao.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import jing.chao.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author isi
 * @date 2020/4/1 16:20
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentFeignHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String getPaymentHystrixOK(@PathVariable("id") Long id) {
        return paymentFeignHystrixService.getPaymentHystrixOK(id);
    }
    @GetMapping("/payment/hystrix/ok2/{id}")
    public String getPaymentHystrixOK2(@PathVariable("id") Long id) {
        int a = 1/0;
        return "ok2";
    }

    @HystrixCommand
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String getPaymentHystrixTimeout(@PathVariable("id") Long id) {
        return paymentFeignHystrixService.getPaymentHystrixTimeout(id);
    }

    /**
     * 全局fallback
     *
     * @return
     */
    public String paymentGlobalFallbackMethod() {
        return "Global异常处理信息,请稍后重试.o(╥﹏╥)o";
    }

}
