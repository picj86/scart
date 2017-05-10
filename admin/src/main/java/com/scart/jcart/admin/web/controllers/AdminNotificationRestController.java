package com.scart.jcart.admin.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.scart.jcart.entities.AdminNotification;
import com.scart.jcart.notification.NotificationService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/*
 * Demonstrates how to set up RESTful API end points using Spring MVC
 */

@RestController
@RequestMapping(value = "/notification/v1/admin")
@Api(value = "admin", description = "Notification API")
public class AdminNotificationRestController extends AbstractRestController {

	@Autowired
	private NotificationService notificationService;

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create a AdminNotification resource.", notes = "Returns the URL of the new resource in the Location header.")
	public void createHotel(@RequestBody AdminNotification notification, HttpServletRequest request,
			HttpServletResponse response) {
		this.notificationService.createAdminNotification(notification);

		response.setHeader("Location",
				request.getRequestURL().append("/").append(notification.getNotification_id()).toString());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = { "application/json",
			"application/xml" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete a AdminNotification resource.", notes = "You have to provide a valid notification ID in the URL. Once deleted the resource can not be recovered.")
	public void deleteHotel(
			@ApiParam(value = "The ID of the existing hotel resource.", required = true) @PathVariable("id") Integer id,
			HttpServletRequest request, HttpServletResponse response) {
		checkResourceFound(this.notificationService.getAdminNotificationById(id));
		this.notificationService.deleteAdminNotificationById(id);
	}
	
	@RequestMapping(value ="/{name}", method = RequestMethod.GET)
	public String greet(@PathVariable String name){
		return "Hello " + name;
	}
	
	

}
