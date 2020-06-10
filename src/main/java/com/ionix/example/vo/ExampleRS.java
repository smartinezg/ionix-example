package com.ionix.example.vo;


public class ExampleRS {
	
	private Integer responseCode;
	private String description;
	private Long elapsedTime;
	private Registers result;
	
	public Integer getResponseCode() {
		return responseCode;
	}
	
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getElapsedTime() {
		return elapsedTime;
	}
	
	public void setElapsedTime(Long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public Registers getResult() {
		return result;
	}

	public void setResult(Registers result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ExampleRS [responseCode=" + responseCode + ", description=" + description + ", elapsedTime="
				+ elapsedTime + ", result=" + result + "]";
	}
		
}
