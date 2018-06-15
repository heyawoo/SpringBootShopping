package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Product;
import com.example.persistence.OrderMapper;
import com.example.web.form.OrderForm;

@Service
public class OrderService {

	@Autowired
	OrderMapper mapper;
	
	// cartに入れている商品のidのマップを利用して商品リストを取得
	public ArrayList<OrderForm> getPnames(HashMap<String, Integer> map, ArrayList<OrderForm> olist){
		
		// productのidの配列
		String[] keys = map.keySet().toArray(new String[map.size()]);
		
		// DBから商品のリスト取得
		List<Product> list = mapper.getPnames(keys);
		
		for (String key : map.keySet()) {
			int num = map.get(key);
			
			for (Product p : list) {
				if (p.getId().equals(key)) {
					
				int price = p.getPrice();
				int total = price*num;
				
				OrderForm order = new OrderForm(key, p.getName(), num+"", p.getPrice(), total, p.getImage1());
				olist.add(order);
				}
			}
		}
		
		return olist;
	}
	
}
