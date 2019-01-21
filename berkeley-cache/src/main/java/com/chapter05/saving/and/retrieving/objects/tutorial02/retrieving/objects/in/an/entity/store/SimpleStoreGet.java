package com.chapter05.saving.and.retrieving.objects.tutorial02.retrieving.objects.in.an.entity.store;

import java.io.File;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.StoreConfig;

public class SimpleStoreGet {

    private static File envHome = new File("./05_dbEnv");
    private Environment envmnt;
    private EntityStore store;
    private SimpleDA sda;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SimpleStoreGet ssg = new SimpleStoreGet();
        try {
            ssg.setup();
            ssg.run();
            ssg.shutdown();
        } catch (DatabaseException dbe) {
            System.err.println("SimpleStoreGet: " + dbe.toString());
            dbe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
            e.printStackTrace();
        }
    }

    // Retrieve some SimpleEntityClass objects from the store.
    private void run() throws DatabaseException {
        //setup();

        // Open the data accessor. This is used to store
        // persistent objects.
        sda = new SimpleDA(store);

        // Instantiate and store some entity classes
        SimpleEntityClass sec1 = sda.pIdx.get("keyone");
        SimpleEntityClass sec2 = sda.pIdx.get("keytwo");
        SimpleEntityClass sec4 = sda.sIdx.get("skeythree");

        System.out.println("sec1: " + sec1.getPKey());
        System.out.println("sec2: " + sec2.getPKey());
        System.out.println("sec4: " + sec4.getPKey());

        //shutdown();
    }
    
    
    // create a method that simply opens our database environment and entity store for us.
    // The setup() method opens the environment and store
    // for us.
    public void setup() throws DatabaseException {
        EnvironmentConfig envConfig = new EnvironmentConfig();
        StoreConfig storeConfig = new StoreConfig();
        
        envConfig.setAllowCreate(true);
        storeConfig.setAllowCreate(true);
        
        // Open the environment and entity store
        envmnt = new Environment(envHome, envConfig);
        store = new EntityStore(envmnt, "EntityStore", storeConfig);
    }
    
    // Close our environment and store.
    public void shutdown() throws DatabaseException {
        store.close();
        envmnt.close();
    }
}
