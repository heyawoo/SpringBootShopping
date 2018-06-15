package com.example.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.service.UserService;
import com.example.web.form.LoginForm;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	@ModelAttribute("loginForm")
	public LoginForm setForm() {
		return new LoginForm();
	}
	
	
	// loginページに遷移
	@RequestMapping("/login")
	public String loginPage(@ModelAttribute("loginForm")LoginForm form) {
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	public String loginCheck(@Validated @ModelAttribute("loginForm")LoginForm form, BindingResult result, HttpSession session) {
		// DBからlogin情報取得
		User user = service.loginCheck(form);
		
		// login情報がある場合
		if (user != null) {
			// 入力したパスワードとIDで検索したUser情報のパスワード比較
			if (user.getPasswd().equals(form.getPasswd())) {
				// loginに成功したユーザ情報をsessionに保存
				session.setAttribute("user", user);
			}else {
				// パスワードが間違っている場合error追加
				result.reject("error.user.login.pw.wrong");
			} 
		} else {
			// IDで検索した結果がない場合error追加
			result.reject("error.user.login.no.account");
		}
		// errorがある場合はlogin画面に戻す
		if (result.hasErrors()) {return "login";}
		
		//　main画面に遷移
		return "redirect:/index";
	}
	
	
	// registerページに遷移
	@RequestMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	// logout
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
}
