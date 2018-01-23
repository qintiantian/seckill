package com.qintiantian.seckill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintiantian.seckill.service.IUserService;
import com.qintiantian.seckill.storage.IUserStorage;

import model.entity.User;
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserStorage userStorage;
	
	public User getUserById(Integer id) {
		return userStorage.getUserById(id);
	}
}
