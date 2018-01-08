/**
 * 
 */
package com.scart.jcart.admin.aws.models.rest;

import java.util.List;

/**
 * @author Prabhakar Jha
 *
 */
public class ItemAttributes {

	private String title;
	private String upc;
	private Price listPrice;
	private Price tradeInValue;
	private String manufacturer;
	private List<String> features;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public Price getListPrice() {
		return listPrice;
	}

	public void setListPrice(Price listPrice) {
		this.listPrice = listPrice;
	}

	public Price getTradeInValue() {
		return tradeInValue;
	}

	public void setTradeInValue(Price tradeInValue) {
		this.tradeInValue = tradeInValue;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "ItemAttributes [title=" + title + ", upc=" + upc + ", listPrice=" + listPrice + ", tradeInValue="
				+ tradeInValue + ", manufacturer=" + manufacturer + ", features=" + features + "]";
	}
}
