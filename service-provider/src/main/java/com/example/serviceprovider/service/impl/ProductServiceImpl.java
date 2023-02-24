package com.example.serviceprovider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serviceprovider.mapper.ProductMapper;
import com.example.serviceprovider.pojo.Product;
import com.example.serviceprovider.service.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lizongzai
 * @since 2023-02-23
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements
    IProductService {

  @Autowired
  private ProductMapper productMapper;

  /**
   * 功能描述: 获取所有商品列表
   *
   * @return
   */
  @Override
  public List<Product> getAllProducts() {
    return productMapper.getAllProducts();
  }
}
