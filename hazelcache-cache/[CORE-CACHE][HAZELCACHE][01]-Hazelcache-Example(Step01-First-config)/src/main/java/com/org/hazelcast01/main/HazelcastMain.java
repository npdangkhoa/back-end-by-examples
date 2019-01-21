package com.org.hazelcast01.main;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelcastMain {
	public static void main(String[] args) {
		HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();
	}
}
