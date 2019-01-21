package com.chapter07a.database.opening.databases.env;

import java.io.File;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;

public class MyDbEnv {
	Environment myDbEnvironment = null;
	Database myDatabase = null;

	// Our constructor does nothing
	public MyDbEnv() {
	}

	// The setup() method opens the environment and store for us.
	public void setup() throws DatabaseException {

		// Open the environment. Create it if it does not already exist.
		EnvironmentConfig envConfig = new EnvironmentConfig();
		envConfig.setAllowCreate(true);

		myDbEnvironment = new Environment(new File("./07_dbEnv"), envConfig);

		// Open the database. Create it if it does not already exist.
		DatabaseConfig dbConfig = new DatabaseConfig();
		dbConfig.setAllowCreate(true);

		//if you configured your environment and database to support transactions, you can
		// optionally provide a transaction object to the Environment.openDatabase().
		myDatabase = myDbEnvironment.openDatabase(null, "sampleDatabase", dbConfig);

	}

}
