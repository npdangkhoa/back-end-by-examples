package com.org.hazelcache02.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.org.hazelcache01.entity.User;

/**
 * The collection of users is managed by the Users class. This is a sample code
 * convenience class that contains a number of hard coded users’ details.
 * 
 * @author knguyen97
 *
 */
public class Users {
	/** The users in the database */
	private final User[] users = { 
			new User("01_fred123", "Fred", "Jones", "fredj@a.com"),
			new User("02_jim", "Jim", "Jones", "jimj@a.com"), 
			new User("03_bill", "Bill", "Jones", "bill@a.com"),
			new User("04_ted111", "Edward", "Jones", "tedj@a.com"),
			new User("05_annie", "Annette", "Jones", "annj@a.com"),
			new User("06_lucy", "Lucy", "Jones", "lucyj@a.com"), 
			new User("07_jimj", "James", "Jones", "jimj@a.com"),
			new User("08_jez", "Jerry", "Jones", "fredj@a.com"), 
			new User("09_will", "William", "Jones", "willj@a.com"),
			new User("10_shaz", "Sharon", "Jones", "shazj@a.com"),
			new User("11_paula", "Paula", "Jones", "pauj@a.com"),
			new User("12_leo", "Leonardo", "Jones", "leoj@a.com"), 
			};

	private final Map<String, User> userMap;

	public Users() {

		userMap = new HashMap<String, User>();

		for (User user : users) {
			userMap.put(user.getUsername(), user);
		}
	}

	/**
	 * The number of users in the database
	 */
	public int size() {
		return userMap.size();
	}

	/**
	 * Given a number, return the user
	 */
	public User getById(int index) {
		return users[index];
	}

	/**
	 * Given the user's name return the User details
	 */
	public User getByEntity(String username) {
		return userMap.get(username);
	}

	/**
	 * Return the user names.
	 */
	public Set<String> FindAll() {
		return userMap.keySet();
	}
}
