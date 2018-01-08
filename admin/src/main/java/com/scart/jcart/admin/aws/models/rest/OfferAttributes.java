/**
 * 
 */
package com.scart.jcart.admin.aws.models.rest;

/**
 * @author Prabhakar Jha
 *
 */
public class OfferAttributes {
	
	private String condition;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OfferAttributes [condition=").append(condition);
		return builder.toString();
	}
}
