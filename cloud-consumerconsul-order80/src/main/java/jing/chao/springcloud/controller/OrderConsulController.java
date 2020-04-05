package jing.chao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author isi
 * @date 2020/4/1 15:38
 */
@RequestMapping("/payment")
@RestController
@Slf4j
public class OrderConsulController {
    private static final String INVOKE_URL = "http://127.0.0.1:8006";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consul")
    public String paymentInfo() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }


}
