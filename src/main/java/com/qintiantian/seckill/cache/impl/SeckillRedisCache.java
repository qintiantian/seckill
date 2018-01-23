package com.qintiantian.seckill.cache.impl;


import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.qintiantian.seckill.cache.ISeckillRedisCache;
import com.qintiantian.seckill.cache.RedisCacheKeyBuilder;
import com.qintiantian.seckill.utils.JSONUtil;

import lombok.extern.slf4j.Slf4j;
import model.entity.User;

@Component
@Slf4j
public class SeckillRedisCache implements ISeckillRedisCache {

	@Autowired
	@Qualifier("redisTemplate	")
	private RedisTemplate<String, String> redisTemplate;

	public User getUserFromRedis(Integer id) {
		try {
			String value = redisTemplate.boundValueOps(RedisCacheKeyBuilder.buildUserInfoKey(id)).get();
			if (StringUtils.isEmpty(value)) {
				return null;
			}
			return JSONUtil.getObjectMapper().readValue(value, User.class);
		} catch (Exception e) {
			log.error("getUserFromRedis occur exception, userId : {}", id, e);
			return null;
		}
	}

	public boolean setUserToRedis(User user) {
		try {
			if(user == null){
				return false;
			}
			String value = JSONUtil.mapToJsonString(user);
			redisTemplate.boundValueOps(RedisCacheKeyBuilder.buildUserInfoKey(user.getId())).set(value, 7, TimeUnit.DAYS);;
			return true;
		} catch (Exception e) {
			log.error("setUserToRedis occur exception, user : {}", user, e);
			return false;
		}
	}
}
