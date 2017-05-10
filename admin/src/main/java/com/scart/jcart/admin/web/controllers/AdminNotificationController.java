package com.scart.jcart.admin.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scart.jcart.entities.AdminNotification;
import com.scart.jcart.notification.NotificationService;

@Controller
public class AdminNotificationController extends SCartAdminBaseController {

	private static final String viewPrefix = "notification/";

	@Autowired
	private NotificationService notificationService;

	@Override
	protected String getHeaderTitle() {
		return "Manage Admin Notification";
	}

	@RequestMapping(value = "/notification", method = RequestMethod.GET)
	public String listAdminNotification(Model model) {
		AdminNotification listNotice = notificationService.getAllAdminNotification();
		model.addAttribute("notification", listNotice);
		return viewPrefix + "notification";
	}
}
