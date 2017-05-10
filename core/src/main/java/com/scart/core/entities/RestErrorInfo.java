package com.scart.core.entities;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * A sample class for adding error information in the response
 * 
 * @author Prabhakar Jha
 *
 */

@XmlRootElement
public class RestErrorInfo {
	public final String detail;
	public final String message;

	public RestErrorInfo(Exception ex, String detail) {
		this.message = ex.getLocalizedMessage();
		this.detail = detail;
	}
}