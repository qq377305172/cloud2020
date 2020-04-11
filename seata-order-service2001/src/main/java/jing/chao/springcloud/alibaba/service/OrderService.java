package jing.chao.springcloud.alibaba.service;

import jing.chao.springcloud.alibaba.domain.Order;

public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}
