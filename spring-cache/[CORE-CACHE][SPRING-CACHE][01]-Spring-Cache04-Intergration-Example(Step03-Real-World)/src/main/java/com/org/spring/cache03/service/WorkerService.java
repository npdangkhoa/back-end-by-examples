package com.org.spring.cache03.service;

import com.org.spring.cache02.beans.Worker;

public interface WorkerService {
	
	Worker getWorkWithId(int id);

	void saveWorker(Worker member);
}
