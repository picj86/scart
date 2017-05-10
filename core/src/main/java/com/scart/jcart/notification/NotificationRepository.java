package com.scart.jcart.notification;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scart.jcart.entities.AdminNotification;


public interface NotificationRepository extends JpaRepository<AdminNotification, Integer>{
	AdminNotification getByTitle(String title);
}