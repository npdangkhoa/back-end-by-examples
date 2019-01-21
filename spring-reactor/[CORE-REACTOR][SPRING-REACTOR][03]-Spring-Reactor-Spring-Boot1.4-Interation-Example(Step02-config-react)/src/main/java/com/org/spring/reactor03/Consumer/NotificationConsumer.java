package com.org.spring.reactor03.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.spring.reactor01.entity.NotificationData;
import com.org.spring.reactor02.service.NotificationService;

import reactor.bus.Event;
import reactor.fn.Consumer;

@Service
public class NotificationConsumer implements Consumer<Event<NotificationData>> {

	@Autowired
	NotificationService service;
	
	@Override
	public void accept(Event<NotificationData> Event) {
		NotificationData notificationData = Event.getData();
		try {
			service.initiateNotification(notificationData);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
