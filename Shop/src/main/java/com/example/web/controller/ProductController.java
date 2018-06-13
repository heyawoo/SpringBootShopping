package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService service;
	
	@RequestMapping("/list")
	public String listPage() {
		return "list";
	}


	@RequestMapping(value="/detail", params="productName")
	public String detailPage() {
		return "productDetail";
	}
}
