package jing.chao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author isi
 * @date 2020/4/1 16:18
 */
@EnableSwagger2
@SpringBootApplication
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
//      # zipkin/sleuth链路跟踪
//#  zipkin:
//            #    base-url: http://localhost:9411
//            #  sleuth:
//            #    sampler:
//            #      # 采样值介于0到1之间,1表示全部采集
//#      probability: 1
//            #eureka:
//            #  client:
//            #    register-with-eureka: true
//            #    fetch-registry: true
//            #    service-url:
//            #      # defaultZone: http://localhost:7001/eureka
//            #      # 集群版
//#      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka
}
