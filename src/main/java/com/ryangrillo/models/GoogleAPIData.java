package com.ryangrillo.models;

import java.util.List;

public class GoogleAPIData {

	private List<Result> results;

	private String status;

	public GoogleAPIData() {
	}

	public GoogleAPIData(List<Result> results, String status) {
		super();
		this.results = results;
		this.status = status;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GoogleAPIData [results=" + results + ", status=" + status + "]";
	}

}