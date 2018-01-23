package com.qintiantian.seckill.cache;

import model.entity.User;

public interface ISeckillRedisCache {

	User getUserFromRedis(Integer id);
	
	boolean setUserToRedis(User user);
}
