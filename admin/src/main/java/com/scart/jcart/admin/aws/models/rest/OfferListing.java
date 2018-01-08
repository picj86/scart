/**
 * 
 */
package com.scart.jcart.admin.aws.models.rest;

/**
 * @author Prabhakar Jha
 *
 */
public class OfferListing {
	private String offerListingId;
	private Price price;
	private Price salePrice;
	private Price amountSaved;
	private int percentageSaved;
	private String availability;

	public String getOfferListingId() {
		return offerListingId;
	}

	public void setOfferListingId(String offerListingId) {
		this.offerListingId = offerListingId;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public int getPercentageSaved() {
		return percentageSaved;
	}

	public void setPercentageSaved(int percentageSaved) {
		this.percentageSaved = percentageSaved;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Price getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Price salePrice) {
		this.salePrice = salePrice;
	}

	public Price getAmountSaved() {
		return amountSaved;
	}

	public void setAmountSaved(Price amountSaved) {
		this.amountSaved = amountSaved;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OfferListing [amountSaved=").append(amountSaved).append(", salePrice").append(salePrice)
				.append(", availability=").append(availability).append(", offerListingId=").append(offerListingId)
				.append(", percentageSaved=").append(percentageSaved).append(", price=").append(price).append("]");
		return builder.toString();
	}
}
