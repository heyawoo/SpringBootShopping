package com.example.web.controller;

import java.util.HashMap;

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
import com.example.web.form.RegisterForm;

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
				// user　cart 生成
				HashMap<String, Integer> map = new HashMap<>();
				if (session.getAttribute("map") != null) {
					map = (HashMap<String, Integer>) session.getAttribute("map");
				}
				session.setAttribute("map", map);
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
	public String registerPage(@ModelAttribute("registerForm")RegisterForm form) {
		return "register";
	}

	// registerページに遷移
	@RequestMapping("/registerCheck")
	public String registerCheck(@Validated @ModelAttribute("registerForm")RegisterForm form, BindingResult result) {
		
		// IDが入力された場合
		if (result.getFieldError("userId") == null) {
			// IDの重複チェック
			Boolean idcheck = service.idCheck(form.getUserId());
			// 重複エラー
			if (!idcheck) {
				result.rejectValue("userId", "error.user.register.id.exist");
			}
		}
		
		// パスワードが入力された場合
		if (result.getFieldError("passwd") == null) {
			// passwordエラー処理
			if (form.getPasswd2()==null || !form.getPasswd().equals(form.getPasswd2())) {
				result.rejectValue("passwd2", "error.user.register.pw.unmatch");
			}
		}
		
		// errorがある場合はlogin画面に戻す
		if (result.hasErrors()) {return "register";}
		
		// DBにユーザ登録
		service.insertUser(form);
		
		// login画面に遷移
		return "redirect:/login?userId="+form.getUserId();
	}
	
	// logout
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
}
