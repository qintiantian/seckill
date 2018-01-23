create database seckill;
use  seckill;

CREATE TABLE IF NOT EXISTS user (
    id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    name varchar(20) NOT NULL COMMENT '名称',
    phone varchar(20) NOT NULL COMMENT '手机号',
    createDateTime datetime DEFAULT NULL COMMENT '创建时间',
    lastUpdateDateTime datetime DEFAULT NULL COMMENT '最后修改时间',
    PRIMARY KEY (id),
    UNIQUE INDEX idx_phone(phone)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS product (
    id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    productName varchar(100) NOT NULL COMMENT '产品名称',
    productDescription varchar(100) DEFAULT NULL COMMENT '产品描述',
    productQuantity int(11) DEFAULT NULL COMMENT '产品数量',
    limitQuantity int(11) DEFAULT NULL COMMENT '限购数量',
    createDateTime datetime DEFAULT NULL COMMENT '创建时间',
    lastUpdateDateTime datetime DEFAULT NULL COMMENT '最后修改时间',
    version int(11) NOT NULL DEFAULT 0 COMMENT '版本号',
    PRIMARY KEY (id),
    UNIQUE INDEX idx_name(productName)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS orders (
    id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    orderId varchar(50) NOT NULL COMMENT '订单号',
    userId bigint(20) DEFAULT NULL COMMENT '用户id',
    productId bigint(20) DEFAULT NULL COMMENT '产品id',
    status varchar(20) DEFAULT NULL COMMENT '状态',
    createDateTime datetime DEFAULT NULL COMMENT '创建时间',
    lastUpdateDateTime datetime DEFAULT NULL COMMENT '最后修改时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;