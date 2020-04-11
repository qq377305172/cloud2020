package jing.chao.springcloud.service;

import jing.chao.springcloud.entity.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author zzyy
 * @version 1.0
 * @date 2020/03/07
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult paymentSQL(Long id) {
        return new CommonResult().fail("fallback");
    }
}
