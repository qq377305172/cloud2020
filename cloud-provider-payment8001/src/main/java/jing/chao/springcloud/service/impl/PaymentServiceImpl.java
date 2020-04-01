package jing.chao.springcloud.service.impl;

import jing.chao.springcloud.dao.PaymentDao;
import jing.chao.springcloud.entity.Payment;
import jing.chao.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author isi
 * @date 2020/4/1 15:36
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
