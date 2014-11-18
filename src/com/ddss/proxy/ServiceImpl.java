package com.ddss.proxy;

public class ServiceImpl implements Service {

	@Override
	public String helloWorld() {
		System.out.println("Hello World!");
		return "Hello World!";
	}

}
