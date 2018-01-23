package com.qintiantian.seckill.dao;

import java.io.Serializable;

import model.entity.BaseEntity;

public interface ISeckillDao {

	<T extends BaseEntity> T findByPK(Class<T> clazz, Serializable id);
}
