package com.example.eurekaserver.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 功能描述: 安全认证配置类
 *
 * @author lizongzai
 * @date 2023/02/24 16:31
 * @since 1.0.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    super.configure(http);
    //忽略 eureka/**的所有请求安全认证
    http.csrf().ignoringAntMatchers("/eureka/**");
    //注意, 若直接disable的会话吧安全验证禁用
    //http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
  }
}