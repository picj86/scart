package com.scart.jcart.admin.aws.models;

import java.io.Serializable;
import java.sql.Timestamp;

public class Catalog  implements Serializable {
	
	/*// Catalog Id
	int id = 0;
	
	// Product Mapping
	String ASIN = "";
	String author = "";
	String manufacturer = "";
	String detailsPageURL = "";
	String title = "";
	
	// Common to All Products
	int merchantId;
	String availability;
	int itemPage;
	String keywords;
	int minPercentageOff;
	float minimumPrice;
	float maximumPrice;
	
	// Other attributes
//	String title;
//	String author;
	String condition;
	String publisher;
	String sort;
	
	
	String brand;
	
	// Movies & TV Shows
	String actor;
	String audienceRating;
	*/
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5890957149417258063L;
	private long amazonimportproducts_id;
	private String amazon_local;
	private String asin;
	private String sku;
	private String condition="All";
	private String categories;
	private String title;
	private int images_count=0;
	private String amazon_product_url;
	private double price = 0.0000;
	private double price_add_percent=0.0000;
	private double price_add_unit=0.0000;
	private String price_type="low";
	private String currency_code= null;
	private int quantity=0;
	private int is_in_stock=0;
	private String offer_listing_id;
	private String description;
	private String data_serialized;
	private int status=0;
	private int checked=0;
	private Timestamp updated;
	public long getAmazonimportproducts_id() {
		return amazonimportproducts_id;
	}
	public void setAmazonimportproducts_id(long amazonimportproducts_id) {
		this.amazonimportproducts_id = amazonimportproducts_id;
	}
	public String getAmazon_local() {
		return amazon_local;
	}
	public void setAmazon_local(String amazon_local) {
		this.amazon_local = amazon_local;
	}
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getImages_count() {
		return images_count;
	}
	public void setImages_count(int images_count) {
		this.images_count = images_count;
	}
	public String getAmazon_product_url() {
		return amazon_product_url;
	}
	public void setAmazon_product_url(String amazon_product_url) {
		this.amazon_product_url = amazon_product_url;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice_add_percent() {
		return price_add_percent;
	}
	public void setPrice_add_percent(double price_add_percent) {
		this.price_add_percent = price_add_percent;
	}
	public double getPrice_add_unit() {
		return price_add_unit;
	}
	public void setPrice_add_unit(double price_add_unit) {
		this.price_add_unit = price_add_unit;
	}
	public String getPrice_type() {
		return price_type;
	}
	public void setPrice_type(String price_type) {
		this.price_type = price_type;
	}
	public String getCurrency_code() {
		return currency_code;
	}
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getIs_in_stock() {
		return is_in_stock;
	}
	public void setIs_in_stock(int is_in_stock) {
		this.is_in_stock = is_in_stock;
	}
	public String getOffer_listing_id() {
		return offer_listing_id;
	}
	public void setOffer_listing_id(String offer_listing_id) {
		this.offer_listing_id = offer_listing_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getData_serialized() {
		return data_serialized;
	}
	public void setData_serialized(String data_serialized) {
		this.data_serialized = data_serialized;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
}
