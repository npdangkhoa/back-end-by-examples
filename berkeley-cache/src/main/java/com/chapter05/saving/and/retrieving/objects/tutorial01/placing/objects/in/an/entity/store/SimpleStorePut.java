package com.chapter05.saving.and.retrieving.objects.tutorial01.placing.objects.in.an.entity.store;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.StoreConfig;

public class SimpleStorePut {

	private static File envHome = new File("./05_dbEnv");
	private Environment envmnt;
	private EntityStore store;
	private SimpleDA sda;

	// main
	public static void main(String args[]) {
		
		
		SimpleStorePut ssp = new SimpleStorePut();
		try {
			ssp.setup();
			ssp.run();
			ssp.shutdown();
			
		} catch (DatabaseException dbe) {
			System.err.println("SimpleStorePut: " + dbe.toString());
			dbe.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
			e.printStackTrace();
		}
		System.out.println("All done.");
	}


	// Populate the entity store
	private void run() throws DatabaseException, FileNotFoundException {
		//setup();

		// Open the data accessor. This is used to store
		// persistent objects.
		sda = new SimpleDA(store);

		// Instantiate and store some entity classes
		SimpleEntityClass sec1 = new SimpleEntityClass();
		SimpleEntityClass sec2 = new SimpleEntityClass();
		SimpleEntityClass sec3 = new SimpleEntityClass();
		SimpleEntityClass sec4 = new SimpleEntityClass();
		SimpleEntityClass sec5 = new SimpleEntityClass();

		sec1.setPKey("keyone");
		sec1.setSKey("skeyone");
		
		sec2.setPKey("keytwo");
		sec2.setSKey("skeyone");
		
		sec3.setPKey("keythree");
		sec3.setSKey("skeytwo");
		
		sec4.setPKey("keyfour");
		sec4.setSKey("skeythree");
		
		sec5.setPKey("keyfive");
		sec5.setSKey("skeyfour");

		sda.pIdx.put(sec1);
		sda.pIdx.put(sec2);
		sda.pIdx.put(sec3);
		sda.pIdx.put(sec4);
		sda.pIdx.put(sec5);

		//shutdown();
	}
	
	

	// The setup() method opens the environment and store
	// for us.
	public void setup() throws DatabaseException, FileNotFoundException {
		EnvironmentConfig envConfig = new EnvironmentConfig();
		StoreConfig storeConfig = new StoreConfig();
		
		envConfig.setAllowCreate(true);
		storeConfig.setAllowCreate(true);
        

		// Open the environment and entity store
		envHome.exists();
		envmnt = new Environment(envHome, envConfig);
		store = new EntityStore(envmnt, "EntityStore", storeConfig);
	}

	// Close our environment and store.
	public void shutdown() throws DatabaseException {
		store.close();
		envmnt.close();
	}
}
