package com.demo.service.domain;

public class DemoService {
	private String name;
	private String custCode;

	
	public DemoService(String name, String custCode) {
		super();
		this.name = name;
		this.custCode = custCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcustCode() {
		return custCode;
	}

	public void setcustCode(String custCode) {
		this.custCode = custCode;
	}
}
