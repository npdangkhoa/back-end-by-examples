package com.org.spring.reactor04.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.org.spring.reactor01.entity.NotificationData;

import reactor.bus.Event;
import reactor.bus.EventBus;

@Controller
public class NotificationController {
	private EventBus eventBus;

	@GetMapping("/startNotification/{param}")
	public void staticNotification(@PathVariable Integer param) {
		for (int i = 0; i < param; i++) {
			NotificationData data = new NotificationData();
			data.setId(i);
			eventBus.notify("notificationConsumer", Event.wrap(data));

			System.out.println("Notification " + i + ": notification task submitted successfully");
		}
	}
}
