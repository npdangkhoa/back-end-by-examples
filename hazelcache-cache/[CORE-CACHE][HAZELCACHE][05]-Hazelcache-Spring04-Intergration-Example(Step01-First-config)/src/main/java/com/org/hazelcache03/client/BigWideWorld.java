package com.org.hazelcache03.client;

import java.util.Random;

import com.org.hazelcache01.entity.User;
import com.org.hazelcache02.database.Users;

public class BigWideWorld {
	private static Random rand = new Random(System.currentTimeMillis());
	private final Users users = new Users();
	private final int totalNumUsers = users.size();

	public String nextUser() {

		User user = users.getById(rand.nextInt(totalNumUsers));
		String name = user.getUsername();

		return name;

	}

}
