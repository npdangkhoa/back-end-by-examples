package com.org.spring.reactor02.service;

import com.org.spring.reactor01.entity.NotificationData;

public interface NotificationService  {
	/**
	 * 
	 * @param notificationData
	 * @throws InterruptedException
	 */
	void initiateNotification(NotificationData notificationData) throws InterruptedException;

}
