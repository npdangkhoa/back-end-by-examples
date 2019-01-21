package com.chapter07c.database.temporary.databases.env;

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

	/**
	 * By default, all JE databases are durable; that is, the data that you put in them will remain
	 * in them across program runs, unless you explicitly delete the data. However, it is possible to
	 * configure a temporary database that is not durable. A temporary database is automatically
	 * deleted when it is closed or after a crash occurs
	 * @throws DatabaseException
	 */
	public void setup() throws DatabaseException {
		try {
			// Open the environment. Create it if it does not already exist.
			EnvironmentConfig envConfig = new EnvironmentConfig();
			envConfig.setAllowCreate(true);

			myDbEnvironment = new Environment(new File("./07_dbEnv"), envConfig);

			// Open the database. Create it if it does not already exist.
			DatabaseConfig dbConfig = new DatabaseConfig();
			dbConfig.setAllowCreate(true);

			// Make it a temporary database
			dbConfig.setTemporary(true);

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
