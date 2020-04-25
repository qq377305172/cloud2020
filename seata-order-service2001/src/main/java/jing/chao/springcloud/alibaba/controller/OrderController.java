package jing.chao.springcloud.alibaba.controller;

import jing.chao.springcloud.alibaba.domain.CommonResult;
import jing.chao.springcloud.alibaba.domain.Order;
import jing.chao.springcloud.alibaba.service.IdGeneratorSnowflake;
import jing.chao.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.*;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private IdGeneratorSnowflake idGeneratorSnowflake;

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @GetMapping("order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }

    /**
     * 生成id,通过雪花算法
     *
     * @return
     */
    @GetMapping("snowflake")
    public String getIDBySnowflake() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 20; i++) {
            executor.submit(() -> {
                System.out.println(idGeneratorSnowflake.snowflakeId());
            });
        }
        executor.shutdown();
        return "hello snowflake";
    }
}
