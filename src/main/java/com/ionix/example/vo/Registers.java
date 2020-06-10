package com.ionix.example.vo;

public class Registers {
	
	private int registerCount;

	public int getRegisterCount() {
		return registerCount;
	}

	public void setRegisterCount(int i) {
		this.registerCount = i;
	}

	@Override
	public String toString() {
		return "Registers [registerCount=" + registerCount + "]";
	}
	
}
