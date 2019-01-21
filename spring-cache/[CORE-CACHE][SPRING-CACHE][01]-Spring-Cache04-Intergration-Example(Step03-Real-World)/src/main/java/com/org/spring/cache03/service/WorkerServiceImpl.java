package com.org.spring.cache03.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.org.spring.cache02.beans.Worker;

@Component
public class WorkerServiceImpl implements WorkerService {

	Worker work = new Worker(1, "Albert Attard");

	@Override
	@Cacheable("workers")
	public Worker getWorkWithId(int id) {
	    System.out.printf("Retrieving the member with id: [%d] from file: %s", id, work.getWorkName());
	    System.out.println("\n");
		return work;
	}

	@Override
	@CacheEvict(value="workers", allEntries=true)
	public void saveWorker(Worker member) {
		this.work.setWorkName(member.getWorkName());
	}

}
