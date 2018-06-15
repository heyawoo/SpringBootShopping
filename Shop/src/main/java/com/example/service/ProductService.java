package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Page;
import com.example.domain.Product;
import com.example.persistence.ProductMapper;
import com.example.web.form.SearchForm;

@Service
public class ProductService {

	@Autowired
	ProductMapper mapper;
	
	public List<Product> getFirstList(){
		List<Product> firstList = mapper.getFirstList(); 
		return firstList;
	}
	
	public Product productDetail(String id) {
		Product p = mapper.getProduct(id);
		return p;
	}
	
	public List<Product> search(SearchForm option){
		if (option.getKeyword().equals("")) {
			option.setKeywords(new String[0]);
		} else {
			String[] keys = option.getKeyword().split(" ");
			option.setKeywords(keys);
		}
		if (option.getSort() == null || option.getSort().equals("")) {
			option.setSort("name");
		}
		
		List<Product> list = mapper.getList(option);
		return list;
	}
	
	public void paging() {
		
		Page page = new Page();
		int totalcount = mapper.getTotalCount();
		int pagesize = 8;
		int totalpage = totalcount/pagesize;
		if (totalcount%pagesize > 0) {
			totalpage++;
		}
		
		int pageno = 1;
		
		
		
	}
	
}
