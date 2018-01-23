package com.qintiantian.seckill.cache;

public class RedisCacheKeyBuilder {

	public static String buildUserInfoKey(Integer id) {
		return String.format("seckill:user:%s", id);
	}
}
