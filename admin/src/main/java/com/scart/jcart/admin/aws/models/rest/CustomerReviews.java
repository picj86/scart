/**
 * 
 */
package com.scart.jcart.admin.aws.models.rest;

/**
 * @author Prabhakar Jha
 *
 */
public class CustomerReviews {

	private String iFrameURL;
	private boolean hasReviews; // boolean true/false
	
	public String getiFrameURL() {
		return iFrameURL;
	}
	public void setiFrameURL(String iFrameURL) {
		this.iFrameURL = iFrameURL;
	}
	public boolean getHasReviews() {
		return hasReviews;
	}
	public void setHasReviews(boolean hasReviews) {
		this.hasReviews = hasReviews;
	}
	@Override
	public String toString() {
		return "CustomerReviews [iFrameURL=" + iFrameURL + ", hasReviews=" + hasReviews + "]";
	}
}
