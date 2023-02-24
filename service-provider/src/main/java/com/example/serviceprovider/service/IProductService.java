package com.example.serviceprovider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serviceprovider.pojo.Product;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lizongzai
 * @since 2023-02-23
 */
public interface IProductService extends IService<Product> {


  /**
   * 功能描述: 获取所有商品列表
   *
   * @return
   */
  List<Product> getAllProducts();

}
