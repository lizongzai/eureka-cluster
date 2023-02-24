package com.example.serviceprovider.service.impl;

import com.example.serviceprovider.pojo.Order;
import com.example.serviceprovider.mapper.OrderMapper;
import com.example.serviceprovider.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizongzai
 * @since 2023-02-24
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
