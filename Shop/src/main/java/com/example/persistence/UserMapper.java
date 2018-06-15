package com.example.persistence;

import com.example.domain.User;
import com.example.web.form.LoginForm;
import com.example.web.form.RegisterForm;

public interface UserMapper {

	public User loginCheck(String userId);
	
	public void insertUser(RegisterForm register);
}
