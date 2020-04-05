package jing.chao.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Admin
 * @title: LoadBalance
 * @projectName cloud2020
 * @description: TODO
 * @date 2020/4/5 10:03
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
