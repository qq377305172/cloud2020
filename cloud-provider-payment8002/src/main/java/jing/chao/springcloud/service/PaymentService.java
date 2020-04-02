package jing.chao.springcloud.service;

import jing.chao.springcloud.entity.Payment;

/**
 * @author isi
 * @date 2020/4/1 15:36
 */

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
