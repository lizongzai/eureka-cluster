package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//开启EurekaClient注解,目前版本若配置了Eureka注册中心, 默认会自动开启注解无需在配置
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.example.mapper")
public class ServiceProviderRibbonApplication {

  public static void main(String[] args) {

    SpringApplication.run(ServiceProviderRibbonApplication.class, args);
  }
}
