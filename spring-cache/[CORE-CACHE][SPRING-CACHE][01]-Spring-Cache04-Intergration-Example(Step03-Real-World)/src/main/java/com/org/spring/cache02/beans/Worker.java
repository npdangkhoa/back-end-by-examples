package com.org.spring.cache02.beans;

import org.springframework.stereotype.Component;


public class Worker {

	private int workId;
	private String workName;

	public Worker(final int workId, final String workName) {
		this.workId = workId;
		this.workName = workName;
	}

	@Override
	public String toString() {
		return String.format("[%d] %s", workId, workName);
	}

	public int getWorkId() {
		return workId;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

}
