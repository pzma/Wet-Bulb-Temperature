package com.ryangrillo.models;

public class InformationObect {
	
	private String category;
	
	private Work work;

	public InformationObect(String category, Work work) {
		super();
		this.category = category;
		this.work = work;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	
}
