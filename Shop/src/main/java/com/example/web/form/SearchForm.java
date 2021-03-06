package com.example.web.form;

import java.util.Arrays;

public class SearchForm {

	private String keyword;
	private String[] keywords;
	private String categoryId;
	private String sort;
	
	public SearchForm() {
		this.keyword = "";
	}

	public SearchForm(String keyword, String[] keywords, String categoryId, String sort) {
		super();
		this.keyword = keyword;
		this.keywords = keywords;
		this.categoryId = categoryId;
		this.sort = sort;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "SearchForm [keyword=" + keyword + ", keywords=" + Arrays.toString(keywords) + ", categoryId="
				+ categoryId + ", sort=" + sort + "]";
	}

	

	
}
