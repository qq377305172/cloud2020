package jing.chao.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Admin
 * @title: PaymentFeignService
 * @projectName cloud2020
 * @description: TODO
 * @date 2020/4/5 10:42
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String getPaymentHystrixOK(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String getPaymentHystrixTimeout(@PathVariable("id") Long id);
}
