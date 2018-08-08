package com.ryangrillo.models;

import java.util.List;

public class Time {

	private String layoutKey;

	private List<String> startPeriodName = null;

	private List<String> startValidTime = null;

	private List<String> tempLabel = null;

	public Time() {
	}

	public Time(String layoutKey, List<String> startPeriodName, List<String> startValidTime, List<String> tempLabel) {
		super();
		this.layoutKey = layoutKey;
		this.startPeriodName = startPeriodName;
		this.startValidTime = startValidTime;
		this.tempLabel = tempLabel;
	}

	public String getLayoutKey() {
		return layoutKey;
	}

	public void setLayoutKey(String layoutKey) {
		this.layoutKey = layoutKey;
	}

	public List<String> getStartPeriodName() {
		return startPeriodName;
	}

	public void setStartPeriodName(List<String> startPeriodName) {
		this.startPeriodName = startPeriodName;
	}

	public List<String> getStartValidTime() {
		return startValidTime;
	}

	public void setStartValidTime(List<String> startValidTime) {
		this.startValidTime = startValidTime;
	}

	public List<String> getTempLabel() {
		return tempLabel;
	}

	public void setTempLabel(List<String> tempLabel) {
		this.tempLabel = tempLabel;
	}

	@Override
	public String toString() {
		return "Time [layoutKey=" + layoutKey + ", startPeriodName=" + startPeriodName + ", startValidTime="
				+ startValidTime + ", tempLabel=" + tempLabel + "]";
	}

}