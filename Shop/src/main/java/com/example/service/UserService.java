package com.example.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.persistence.UserMapper;
import com.example.web.form.LoginForm;
import com.example.web.form.RegisterForm;

@Service
public class UserService {

	@Autowired
	UserMapper mapper;
	
	// 入力したIDでDB検索
	public User loginCheck(LoginForm login) {
		User user = mapper.loginCheck(login.getUserId());
		// 検索結果を返還
		return user;
	}
	
	// 入力したIDでDB検索
	public boolean idCheck(String userId) {
		Boolean result = false;
		User user = mapper.loginCheck(userId);
		// 検索結果が存在しない場合
		if (user == null) {
			// このIDは使える
			result = true;
		}
		return result;
	}
	
	// User登録
	@Transactional
	public void insertUser(RegisterForm register) {
		mapper.insertUser(register);
	}
	
}
