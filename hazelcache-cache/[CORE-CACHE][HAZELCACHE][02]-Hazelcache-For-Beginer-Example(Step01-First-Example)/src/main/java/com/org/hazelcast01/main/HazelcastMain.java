package com.org.hazelcast01.main;

import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;

public class HazelcastMain {
	public static void main(String[] args) {
		HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();
		HazelcastInstance hzInstance2 = Hazelcast.newHazelcastInstance();

		Map<Long, String>  map = hzInstance.getMap("a");
		IdGenerator gen = hzInstance.getIdGenerator("gen");
		for (int i = 0; i < 50; i++) {
			map.put(gen.newId()	, "stuff " + i);
			System.out.println("Add data: " + map.get(gen.newId() - 1));
		}
		
		
		Map<String, String> map2= hzInstance2.getMap("a");
		for (Map.Entry<String, String> entry: map2.entrySet()) {
            System.out.printf("entry: %d; %s\n", entry.getKey(), entry.getValue());
			
		}
		
		System.exit(0);
	}
}
