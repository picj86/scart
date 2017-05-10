/**
 * 
 */
package com.scart.jcart.admin.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Siva
 *
 */
@Controller
public class HomeController extends SCartAdminBaseController
{	
	@Override
	protected String getHeaderTitle() {
		return "Home";
	}
	
	@RequestMapping("/home")
	public String home(Model model)
	{
		return "home";
	}

	@RequestMapping("/dashboard")
	public String dashboard(Model model)
	{
		return "dashboard";
	}
	
	@RequestMapping("/manager_dashboard")
	public String manager_dashboard(Model model)
	{
		return "manager_dashboard";
	}
	@RequestMapping("/admin_dashboard")
	public String admin_dashboardd(Model model)
	{
		return "admin_dashboard";
	}

}
