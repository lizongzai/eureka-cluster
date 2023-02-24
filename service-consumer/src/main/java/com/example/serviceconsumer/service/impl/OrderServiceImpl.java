package com.example.serviceconsumer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.serviceconsumer.mapper.OrderMapper;
import com.example.serviceconsumer.pojo.Order;
import com.example.serviceconsumer.pojo.Product;
import com.example.serviceconsumer.service.IOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lizongzai
 * @since 2023-02-24
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private DiscoveryClient discoveryClient;
  @Autowired
  private OrderMapper orderMapper;

  /**
   * 获取订单
   *
   * @param id
   * @return
   */
  @Override
  public Order getOrderById(Integer id) {

    //调用DiscoveryClient生成商品列表
    List<Product> productList = selectProductListByDiscoverClient();

    //获取订单信息
    Order orderById = orderMapper.getOrderById(id);
    Order order = new Order();
    order.setId(orderById.getId());
    order.setOrderNo(orderById.getOrderNo());
    order.setOrderAddress(orderById.getOrderAddress());
    order.setTotalPrice(orderById.getTotalPrice());
    order.setProductList(productList);
    return order;
  }

  /**
   * 使用DiscoveryClient调用其它微服务
   *
   * @return
   */
  private List<Product> selectProductListByDiscoverClient() {

    //获取服务列表
    List<String> serviceIds = discoveryClient.getServices();
    if (CollectionUtils.isEmpty(serviceIds)) {
      return null;
    }

    //根据服务名称获取微服务
    List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
    if (CollectionUtils.isEmpty(instances)) {
      return null;
    }

    //获取商品列表
    ServiceInstance serviceInstance = instances.get(0);
    StringBuffer sb = new StringBuffer();
    sb.append(
        "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/list");

    //ResponseEntity封装返回数据
    ResponseEntity<List<Product>> response = restTemplate.exchange(
        sb.toString(),
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Product>>() {
        });

    return response.getBody();
  }
}
