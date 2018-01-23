package com.qintiantian.seckill.dao.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.qintiantian.seckill.dao.ISeckillDao;

import model.entity.BaseEntity;

@Service
public class SeckillDao implements ISeckillDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public <T extends BaseEntity> T findByPK(Class<T> clazz, Serializable id) {
		return hibernateTemplate.get(clazz, id);
	}
}
