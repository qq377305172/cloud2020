package jing.chao.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Admin
 * @title: PaymentFallbackService
 * @projectName cloud2020
 * @description: TODO
 * @date 2020/4/5 15:12
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String getPaymentHystrixOK(Long id) {
        return "系统超时或异常";
    }

    @Override
    public String getPaymentHystrixTimeout(Long id) {
        return "系统超时或异常";
    }
}
