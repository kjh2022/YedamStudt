package com.yedam.product0808;

import com.yedam.common0808.DAO;

/*product_id VARCHAR2(100) primary key,
product_name VARCHAR2(100) not null,
product_price NUMBER not null,
product_explain VARCHAR2(4000),
product_sales NUMBER default 0,
stores VARCHAR2(100));*/

public class Product extends DAO {
	private String productId;
	private String productName;
	private int productPrice;

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	private String productExplain;
	private int productSales;
	private String stores;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductExplain() {
		return productExplain;
	}

	public void setProductExplain(String productExplain) {
		this.productExplain = productExplain;
	}

	public int getProductSales() {
		return productSales;
	}

	public void setProductSales(int productSales) {
		this.productSales = productSales;
	}

	public String getStores() {
		return stores;
	}

	public void setStores(String stores) {
		this.stores = stores;
	}
}
