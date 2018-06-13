package com.example.domain;

public class Product {

	private String id;
	private String categoryId;
	private String name;
	private int price;
	private int stockQuantity;
	private String image1;
	private String image2;
	
	public Product() {
	}

	public Product(String id, String categoryId, String name, int price, int stockQuantity, String image1,
			String image2) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.image1 = image1;
		this.image2 = image2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", price=" + price
				+ ", stockQuantity=" + stockQuantity + ", image1=" + image1 + ", image2=" + image2 + "]";
	}
	
}
