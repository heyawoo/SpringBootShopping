package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService service;
	
	@RequestMapping("/cart")
	public String cartPage() {
		return "cart";
	}

}
