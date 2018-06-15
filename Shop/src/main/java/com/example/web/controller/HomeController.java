package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Product;
import com.example.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	ProductService service;
	
	@RequestMapping({"/index", "/main", "/menu"})
	public String indexPage(Model model) {
		
		List<Product> firstList = service.getFirstList();
		model.addAttribute("firstList", firstList);
		
		return "index";
	}
	
}
