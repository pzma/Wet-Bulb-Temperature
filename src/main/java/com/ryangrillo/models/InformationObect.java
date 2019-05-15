package com.ryangrillo.models;

public class InformationObect {
	
	private String risk;
	
	private Work work;

	public InformationObect(String risk, Work work) {
		super();
		this.risk = risk;
		this.work = work;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	
}
