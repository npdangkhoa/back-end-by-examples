package com.chapter05.saving.and.retrieving.objects.tutorial03.retrieving.multiple.objects;

import java.util.Iterator;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.EntityCursor;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.PrimaryIndex;
import com.sleepycat.persist.SecondaryIndex;

public class SimpleDA {

    // Index Accessors
    PrimaryIndex<String, SimpleEntityClass> pIdx;
    SecondaryIndex<String, String, SimpleEntityClass> sIdx;

    // Open the indices
    public SimpleDA(EntityStore store) throws DatabaseException {

        // Primary key for SimpleEntityClass classes
        pIdx = store.getPrimaryIndex(String.class, SimpleEntityClass.class);
        EntityCursor<SimpleEntityClass> pi_cursor = pIdx.entities();

        try {
            Iterator<SimpleEntityClass> i = pi_cursor.iterator();
            while (i.hasNext()) {

            }
        } finally {
            pi_cursor.close();
        }

    }

}