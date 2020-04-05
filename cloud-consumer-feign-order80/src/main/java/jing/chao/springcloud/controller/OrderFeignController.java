package jing.chao.springcloud.controller;

import jing.chao.springcloud.entity.CommonResult;
import jing.chao.springcloud.service.PaymentFeignService;
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
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<?> get(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/payment/timeout")
    public String getTimeout() {
        return paymentFeignService.getTimeout();
    }

}
