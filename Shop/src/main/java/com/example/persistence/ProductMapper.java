package com.example.persistence;

import java.util.List;

import com.example.domain.Product;
import com.example.web.form.SearchForm;

public interface ProductMapper {

	public List<Product> getFirstList();
	
	public Product getProduct(String id);

	public List<Product> getList(SearchForm option);
}
