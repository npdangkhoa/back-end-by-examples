package com.chapter02.database.environments;

import java.io.File;
import java.io.FileNotFoundException;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws FileNotFoundException {
		// Open the environment. Allow it to be created if it does not already
		// exist.
		Environment myDbEnvironment = null;

		try {
			// Open/Create Environment
			EnvironmentConfig envConfig = new EnvironmentConfig();
			envConfig.setTransactional(true);
			envConfig.setAllowCreate(true);
			myDbEnvironment = new Environment(new File("./02_dbEnv"), envConfig);
	
			
		} catch (DatabaseException dbe) {
			// Exception handling goes here
		} finally {
			
			//Closing Database Environments
			if (myDbEnvironment != null) {
				myDbEnvironment.close();
			}	
		}

	}
}
