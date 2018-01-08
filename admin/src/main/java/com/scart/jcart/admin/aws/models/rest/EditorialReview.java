/**
 * 
 */
package com.scart.jcart.admin.aws.models.rest;

/**
 * @author Prabhakar Jha
 *
 */
public class EditorialReview {
	
	private String source; // Product Title
	private String content; // Product's content
	private int isLinkSuppressed;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsLinkSuppressed() {
		return isLinkSuppressed;
	}
	public void setIsLinkSuppressed(int isLinkSuppressed) {
		this.isLinkSuppressed = isLinkSuppressed;
	}
	@Override
	public String toString() {
		return "EditorialReview [source=" + source + ", content=" + content + ", isLinkSuppressed=" + isLinkSuppressed
				+ "]";
	}
	
}
