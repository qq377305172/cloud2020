package jing.chao.springcloud.service;

import jing.chao.springcloud.entity.CommonResult;
import jing.chao.springcloud.entity.Payment;
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
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/timeout")
    String getTimeout();
}
