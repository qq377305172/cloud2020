package jing.chao.springcloud.dao;

import jing.chao.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author isi
 * @date 2020/4/1 15:17
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
