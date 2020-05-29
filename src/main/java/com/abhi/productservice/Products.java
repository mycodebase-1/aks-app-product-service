package com.abhi.productservice;

import org.springframework.data.annotation.Id;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;

@Document(collection = "product-service")
public class Products {

	@Id
	// @Column(name = "product_id")
	private Integer productId;

	// @Column(name = "product_name")
	private String productName;

	// @Column(name = "product_company")
	private String productCompany;

	// @Column(name = "product_category")
	private String productCategory;

	public Products(Integer productId, String productName, String productCompany, String productCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCompany = productCompany;
		this.productCategory = productCategory;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCompany() {
		return productCompany;
	}

	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

}