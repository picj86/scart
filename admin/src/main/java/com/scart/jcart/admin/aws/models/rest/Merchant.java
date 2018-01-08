/**
 * 
 */
package com.scart.jcart.admin.aws.models.rest;

/**
 * @author Prabhakar Jha
 *
 */
public class Merchant {
	private String merchantId;
	private String glancePage;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getGlancePage() {
		return glancePage;
	}

	public void setGlancePage(String glancePage) {
		this.glancePage = glancePage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Merchant [glancePage=").append(glancePage).append(", merchantId=").append(merchantId)
				.append("]");
		return builder.toString();
	}

}
