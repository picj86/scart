package com.scart.core.notification;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scart.core.entities.AdminNotification;
/**
 * 
 * @author Prabhakar Jha
 *
 */

public interface NotificationRepository extends JpaRepository<AdminNotification, Integer>{
	AdminNotification getByTitle(String title);
}