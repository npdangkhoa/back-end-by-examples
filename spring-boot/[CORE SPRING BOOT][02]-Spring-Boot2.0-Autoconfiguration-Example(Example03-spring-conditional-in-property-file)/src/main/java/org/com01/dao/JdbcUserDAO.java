package org.com01.dao;

import java.util.Arrays;
import java.util.List;

public class JdbcUserDAO implements UserDAO {

	@Override
	public List<String> getAllUserName() {
		System.out.println("**** Getting usernames from RDBMS *****");
		return Arrays.asList("Bond", "James", "Bond");
	}

}
