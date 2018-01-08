/**
 * 
 */
package com.scart.jcart.admin.aws.exception;

/**
 * @author Prabhakar Jha
 *
 */
public class ItemLookupException extends AmazonRequestException {

	private static final long serialVersionUID = 6134079719885439105L;

	public ItemLookupException(String message) {
		super(message);
	}

	public ItemLookupException(String message, Throwable cause) {
		super(message, cause);
	}

}
