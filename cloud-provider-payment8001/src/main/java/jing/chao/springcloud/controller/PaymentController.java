package jing.chao.springcloud.controller;

import jing.chao.springcloud.entity.CommonResult;
import jing.chao.springcloud.entity.Payment;
import jing.chao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
        return new CommonResult<Payment>().success(payment);
    }

}