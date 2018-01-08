/**
 * 
 */
package com.scart.jcart.admin.aws.exception;

/**
 * @author Prabhakar Jha
 *
 */
public class AmazonRequestException extends RuntimeException {

	private static final long serialVersionUID = 2983143260556805186L;

	public AmazonRequestException(String message) {
		super(message);
	}

	public AmazonRequestException(String message, Throwable cause) {
		super(message, cause);
	}

}
