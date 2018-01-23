package com.qintiantian.seckill.storage.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qintiantian.seckill.cache.ISeckillRedisCache;
import com.qintiantian.seckill.dao.ISeckillDao;
import com.qintiantian.seckill.storage.IUserStorage;

import model.entity.User;

@Component
public class UserStorage implements IUserStorage {

	@Autowired
	private ISeckillDao seckillDao;

	@Autowired
	private ISeckillRedisCache seckillRedisCache;

	public User getUserById(Integer id) {
		User user = seckillRedisCache.getUserFromRedis(id);
		if (user == null) {
			user = seckillDao.findByPK(User.class, id);
			if (user != null) {
				seckillRedisCache.setUserToRedis(user);
			}
		}
		return user;
	}

}
