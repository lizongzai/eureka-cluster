#创建数据库
create database micro_service charset "utf8";

#创建t_product表
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`
(
    `id`           int(11)                                                NOT NULL AUTO_INCREMENT COMMENT '商品ID',
    `productName`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
    `productNum`   int(11)                                                NULL DEFAULT NULL COMMENT '商品数量',
    `productPrice` double                                                 NULL DEFAULT NULL COMMENT '商品价格',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 149
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;


#创建t_order表
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`
(
    `id`           int(11)                                                 NOT NULL AUTO_INCREMENT COMMENT '订单ID',
    `orderNo`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '订单编码',
    `orderAddress` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单地址',
    `totalPrice`   double                                                  NULL DEFAULT NULL COMMENT '订单总格',
    PRIMARY KEY (`id`) USING BTREE

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;