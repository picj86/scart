/**
 * 
 */
package com.scart.jcart.admin.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Siva
 *
 */
@Controller
public class ErrorController {
	private static final String viewPrefix = "error/";
	
	@RequestMapping("/403")
	public String internalError()
	{
		return viewPrefix+"accessDenied";
	}
	
	protected String getErrorTitle() {
		return viewPrefix;
	}
	
}
