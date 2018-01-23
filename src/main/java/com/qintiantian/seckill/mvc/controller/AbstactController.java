package com.qintiantian.seckill.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.qintiantian.seckill.exception.IllegalArgException;
import com.qintiantian.seckill.service.IUserService;

import model.entity.User;

@Component
public abstract class AbstactController {

	@Autowired
	private IUserService userService;

	public void checkUser(Integer id) {
		User user = userService.getUserById(id);
		if (user == null) {
			//throw new Res
		}
	}
	
}
