package jing.chao.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Admin
 * @title: ApplicationContextConfig
 * @projectName cloud2020
 * @description: TODO
 * @date 2020/4/4 19:31
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
