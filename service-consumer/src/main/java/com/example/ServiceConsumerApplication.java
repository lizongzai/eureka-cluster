package com.example;

import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.example.serviceconsumer.mapper")
public class ServiceConsumerApplication {

  //添加负载均衡全局策略
//  @Bean
//  public RandomRule randomRule() {
//    return new RandomRule();
//  }

  //RestTemplate是一个同步的web http客户端请求模板工具
  @Bean
  //@LoadBalanced //负载均衡注解
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(ServiceConsumerApplication.class,args);
  }

}
