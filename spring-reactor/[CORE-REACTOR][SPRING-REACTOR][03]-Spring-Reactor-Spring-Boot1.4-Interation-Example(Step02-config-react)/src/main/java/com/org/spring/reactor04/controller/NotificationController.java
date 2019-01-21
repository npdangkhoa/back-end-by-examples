package com.org.spring.reactor04.controller;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AcceptAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.spring.reactor01.entity.NotificationData;

import reactor.bus.Event;
import reactor.bus.EventBus;

@Controller
public class NotificationController {
	
	@Autowired
	private EventBus eventBus;

	@RequestMapping(value = "/startNotification/{param}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public void staticNotification(@PathVariable Integer param) {
		for (int i = 0; i < param; i++) {
			NotificationData data = new NotificationData();
			data.setId(i);
			eventBus.notify("notificationConsumer", Event.wrap(data));

			System.out.println("Notification " + i + ": notification task submitted successfully");
		}
	}
}
