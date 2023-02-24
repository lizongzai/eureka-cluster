package com.example.serviceconsumer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.serviceconsumer.pojo.Order;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lizongzai
 * @since 2023-02-24
 */
public interface OrderMapper extends BaseMapper<Order> {

  /**
   * 获取订单
   *
   * @param id
   * @return
   */
  Order getOrderById(Integer id);
}
