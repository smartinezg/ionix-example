package com.ionix.example.services.consumer.rest.get.vo;

public class SearchRS {

	private int responseCode;
	private String description;
	private Items result;
	
	public int getResponseCode() {
		return responseCode;
	}
	
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Items getResult() {
		return result;
	}
	
	public void setResult(Items result) {
		this.result = result;
	}
	
}
