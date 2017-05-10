package com.scart.jcart.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scart.jcart.entities.AdminNotification;

@Service
@Transactional
public class NotificationService {
	@Autowired
	NotificationRepository notificationRepository;

	public AdminNotification getAllAdminNotification() {
		return (AdminNotification) notificationRepository.findAll();
	}
	
	public  AdminNotification getAdminNotificationById(Integer id) {
		return notificationRepository.findOne(id);
	}
	
	public void deleteAdminNotificationById(Integer id){
		notificationRepository.delete(id);
	}
	public void deleteSelectedAdminNotification(List<AdminNotification> admin){
		notificationRepository.delete(admin);
	}
	
	public void deleteAllAdminNotification(){
		notificationRepository.deleteAll();
	}
	
	public void createAdminNotification(AdminNotification admin){
		notificationRepository.save(admin);
	}
}
