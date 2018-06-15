package com.example.web.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Product;
import com.example.service.ProductService;
import com.example.web.form.SearchForm;

@Controller
public class ProductController {

	@ModelAttribute("option")
	public SearchForm setForm() {
		return new SearchForm();
	}
	
	@Autowired
	ProductService service;
	
	@RequestMapping("/list")
	public String listPage(@ModelAttribute("option")SearchForm option, Model model) {
		
		// DBから検索条件に該当するproductのlist取得
		List<Product> list = service.search(option);
		// HTMLページへ伝達
		model.addAttribute("list", list);
		
		return "list";
	}


	@RequestMapping(value="/detail", params="id")
	public String detailPage(@Param("id")int id, Model model) {
		
		// 渡されたidを利用してDBから
		Product product = service.productDetail(id+"");
		// HTMLページへ伝達
		model.addAttribute("product", product);
		
		return "productDetail";
	}
}
