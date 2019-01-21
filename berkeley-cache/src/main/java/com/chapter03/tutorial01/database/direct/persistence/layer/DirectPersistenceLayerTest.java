package com.chapter03.tutorial01.database.direct.persistence.layer;

import java.io.File;
import java.util.logging.Logger;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.Transaction;
import com.sleepycat.persist.EntityCursor;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.PrimaryIndex;
import com.sleepycat.persist.SecondaryIndex;
import com.sleepycat.persist.StoreConfig;

public class DirectPersistenceLayerTest {
	
    private static Logger LOG= Logger.getLogger(DirectPersistenceLayerTest.class.getName());
    private Environment environment=null;
    private EntityStore store;
    private PrimaryIndex<Long, Individual> individualById;
    private SecondaryIndex<String, Long, Individual> individualByLastName;

    
	public static void main(String[] args) {
		DirectPersistenceLayerTest app = new DirectPersistenceLayerTest();
		try {
			int optind = 0;
			while (optind < args.length) {
				if (args[optind].equals("-h")) {
					System.err.println("");
				} else if (args[optind].equals("--")) {
					optind++;
					break;
				} else if (args[optind].startsWith("-")) {
					System.err.println("Unknown option " + args[optind]);
				} else {
					break;
				}
				++optind;
			}
			//new File("./dbEnv_").getAbsolutePath();
			app.open(new File("./03_dbEnv"));
			app.run();
		} catch (Throwable err) {
			err.printStackTrace();
		} finally {
			app.close();
		}
		LOG.info("done.");
	}
	
	void run() throws DatabaseException
    {
    Transaction txn;
    LOG.info("count.individuals="+ individualById.count());
    //create a transaction
    txn= environment.beginTransaction(null, null);

    Individual gp1= new Individual("Robert","Darwin",1);
    //Put class objects to the store using the PrimaryIndex.put() method.
    individualById.put(gp1);
    Individual gm1= new Individual("Susannah","Wedgwood",2);
    individualById.put(gm1);
    Individual gp2= new Individual("Josiah","Wedgwood",1);
    individualById.put(gp2);
    Individual gm2= new Individual("Elisabeth","Allen",2);
    individualById.put(gm2);

    Individual father= new Individual("Charles","Darwin",1);
    father.setFatherId(gp1.getId());
    father.setMotherId(gm1.getId());
    individualById.put(father);
    Individual mother= new Individual("Emma","Wedgwood",2);
    mother.setFatherId(gp2.getId());
    mother.setMotherId(gm2.getId());
    individualById.put(mother);


    Individual c1= new Individual("William","Darwin",1);
    c1.setFatherId(father.getId());
    c1.setMotherId(mother.getId());
    individualById.put(c1);
    Individual c2= new Individual("Anne Elisabeth","Darwin",2);
    c2.setFatherId(father.getId());
    c2.setMotherId(mother.getId());
    individualById.put(c2);

    txn.commit();



    System.out.println("###Listing all Darwin");
    EntityCursor<Individual> cursor = individualByLastName.entities("Darwin", true, "Darwin", true);
    for(Individual indi:cursor)
            {
            System.out.println(indi.getLastName()+"\t"+indi.getFirstName()+"\t"+indi.getId());
            }
    cursor.close();

    LOG.info("count.individuals="+individualById.count());
    }
	
	
	public void open(File dir) throws DatabaseException {
		close();
        EnvironmentConfig envCfg= new EnvironmentConfig();
        StoreConfig storeCfg= new StoreConfig();
        storeCfg.setAllowCreate(true);
        envCfg.setTransactional(true);
        
        LOG.info("opening "+dir);
        this.environment= new Environment(dir,envCfg);
        this.store= new EntityStore(this.environment,"StoreName",storeCfg);
        
        //Retrieve the store's primary index for a given class using the
        this.individualById = this.store.getPrimaryIndex(Long.class, Individual.class);
        
        this.individualByLastName= this.store.getSecondaryIndex(this.individualById, String.class, "lastName");
	}
	
	
	public void close() {
		if (this.store != null) {
			LOG.info("close store");
			try {
				this.store.close();
			} catch (DatabaseException e) {
				LOG.warning(e.getMessage());
			}
			this.store = null;
		}

		if (this.environment != null) {
			LOG.info("close env");
			try {
				this.environment.cleanLog();
				this.environment.close();
			} catch (DatabaseException e) {
				LOG.warning(e.getMessage());
			}
			this.environment = null;
		}
	}
}
