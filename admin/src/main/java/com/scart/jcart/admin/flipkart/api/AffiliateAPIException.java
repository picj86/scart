package com.scart.jcart.admin.flipkart.api;

/***
 * The Exception class.
 * Please refer to the instructions.txt
 *
 * @author vijay.v@flipkart.com
 * @version 1.0
 * Copyright (c) Flipkart India Pvt. Ltd.
 */

import java.lang.Exception;

public class AffiliateAPIException extends Exception {
	
	private static final long serialVersionUID = 6479717362035254757L;

	AffiliateAPIException(String message) {
		super(message);
	}
}