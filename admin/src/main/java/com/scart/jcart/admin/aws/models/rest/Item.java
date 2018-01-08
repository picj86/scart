/**
 * 
 */
package com.scart.jcart.admin.aws.models.rest;

/**
 * @author pj0014676
 *
 */
public class Item {

	private String asin;
	private String detailPageURL;
	private Image smallImage;
	private Image mediumImage;
	private Image largeImage;
	private ItemAttributes itemAttributes;
	private OfferSummary offerSummary;
	private Offers offers;
	private CustomerReviews customerReviews;
	private EditorialReviews editorialReviews;
	

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getDetailPageURL() {
		return detailPageURL;
	}

	public void setDetailPageURL(String detailPageURL) {
		this.detailPageURL = detailPageURL;
	}

	public ItemAttributes getItemAttributes() {
		return itemAttributes;
	}

	public void setItemAttributes(ItemAttributes itemAttributes) {
		this.itemAttributes = itemAttributes;
	}

	public OfferSummary getOfferSummary() {
		return offerSummary;
	}

	public void setOfferSummary(OfferSummary offerSummary) {
		this.offerSummary = offerSummary;
	}

	public Offers getOffers() {
		return offers;
	}

	public void setOffers(Offers offers) {
		this.offers = offers;
	}

	public Image getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(Image smallImage) {
		this.smallImage = smallImage;
	}

	public Image getMediumImage() {
		return mediumImage;
	}

	public void setMediumImage(Image mediumImage) {
		this.mediumImage = mediumImage;
	}

	public Image getLargeImage() {
		return largeImage;
	}

	public void setLargeImage(Image largeImage) {
		this.largeImage = largeImage;
	}

	public CustomerReviews getCustomerReviews() {
		return customerReviews;
	}

	public void setCustomerReviews(CustomerReviews customerReviews) {
		this.customerReviews = customerReviews;
	}

	public EditorialReviews getEditorialReviews() {
		return editorialReviews;
	}

	public void setEditorialReviews(EditorialReviews editorialReviews) {
		this.editorialReviews = editorialReviews;
	}

	@Override
	public String toString() {
		return "Item [asin=" + asin + ", detailPageURL=" + detailPageURL + ", smallImage=" + smallImage
				+ ", mediumImage=" + mediumImage + ", largeImage=" + largeImage + ", itemAttributes=" + itemAttributes
				+ ", offerSummary=" + offerSummary + ", offers=" + offers + ", customerReviews=" + customerReviews
				+ ", editorialReviews=" + editorialReviews + "]";
	}
}
