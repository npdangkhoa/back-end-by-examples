package com.chapter07b.database.deferred.write.databases.env;

import java.io.File;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;

//By default, JE database operations that modify the database are written (logged) at the time
//of the operation. For transactional databases, changes become durable when the transaction
//is committed
public class MyDbEnv {
	Environment myDbEnvironment = null;
	Database myDatabase = null;

	public MyDbEnv() {
	}

	// The setup() method opens the environment and store for us.
	public void setup() throws DatabaseException {
		try {
			// Open the environment. Create it if it does not already exist.
			EnvironmentConfig envConfig = new EnvironmentConfig();
			envConfig.setAllowCreate(true);

			myDbEnvironment = new Environment(new File("./07_dbEnv"), envConfig);

			// Open the database. Create it if it does not already exist.
			DatabaseConfig dbConfig = new DatabaseConfig();
			dbConfig.setAllowCreate(true);

			// Make it deferred write
			//If you are using the DPL, then you configure your entire store to be deferred write
			dbConfig.setDeferredWrite(true);

			// if you configured your environment and database to support transactions, you
			// can
			// optionally provide a transaction object to the Environment.openDatabase().
			myDatabase = myDbEnvironment.openDatabase(null, "sampleDatabase", dbConfig);

			/**
			 * 
			 * DO WORK
			 * 
			 */

			// Do this when you want the work to be persistent at a
			// specific point, prior to closing the database.
			myDatabase.sync();

			// then close the database and environment here
			// (described later in this chapter).
		} catch (DatabaseException dbe) {
			// Exception handling goes here
		}
	}

}
