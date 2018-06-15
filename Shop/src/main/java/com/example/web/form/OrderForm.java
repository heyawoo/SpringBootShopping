package com.example.web.form;

public class OrderForm {

	private String pid;
	private String pname;
	private String num;
	private int	price;
	private int total;
	private String image1;
	
	public OrderForm() {
	}

	public OrderForm(String pid, String pname, String num, int price, int total, String image1) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.num = num;
		this.price = price;
		this.total = total;
		this.image1 = image1;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	@Override
	public String toString() {
		return "OrderForm [pid=" + pid + ", pname=" + pname + ", num=" + num + ", price=" + price + ", total=" + total
				+ ", image1=" + image1 + "]";
	}

	
	
}
