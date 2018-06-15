package com.example.web.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.OrderService;
import com.example.web.form.OrderForm;

@Controller
public class OrderController {

	@Autowired
	OrderService service;
	
	@RequestMapping("/cartPut")
	public String cart(@Param("pid") String pid, @Param("num")String num, HttpSession session) {
		
		HashMap<String, Integer> map = (HashMap<String, Integer>) session.getAttribute("map");
		if (map == null) {
			map = new HashMap<>();
		}
		if (map.get(pid) != null) {
			map.put(pid, map.get(pid)+Integer.parseInt(num));
		} else {
			map.put(pid, Integer.parseInt(num));
		}
		session.setAttribute("map", map);
		return "redirect:/order";
	}
	
	@RequestMapping("/cart")
	public String cartPage(HttpSession session, Model model) {
		
		ArrayList<OrderForm> orderList = (ArrayList<OrderForm>) session.getAttribute("orderList");
		
		model.addAttribute("list", orderList);
		
		return "cart";
	}
	
	@RequestMapping("/order")
	public String orderPage(@ModelAttribute("order")OrderForm form, Model model, HttpSession session) {
		HashMap<String, Integer> map = (HashMap<String, Integer>) session.getAttribute("map");
		
		ArrayList<OrderForm> orderList = new ArrayList<>();
		
		orderList = service.getPnames(map, orderList);
		
		session.setAttribute("orderList", orderList);

		
		return "redirect:/cart";
	}

}
