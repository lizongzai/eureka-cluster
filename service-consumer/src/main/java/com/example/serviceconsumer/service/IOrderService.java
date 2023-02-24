package com.example.serviceconsumer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serviceconsumer.pojo.Order;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lizongzai
 * @since 2023-02-24
 */
public interface IOrderService extends IService<Order> {

  /**
   * 获取订单
   *
   * @param id
   * @return
   */
  Order getOrderById(Integer id);
}
