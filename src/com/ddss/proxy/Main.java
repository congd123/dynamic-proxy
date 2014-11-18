package com.ddss.proxy;

import java.lang.reflect.Proxy;
import java.util.StringJoiner;

public class Main {
	public static void main(String[] args) {
		Service service = new ServiceImpl();

		Service proxyService = (Service) Proxy.newProxyInstance(Service.class.getClassLoader(), service.getClass().getInterfaces(), (proxy, method, arguments) -> {
			long startTime = System.currentTimeMillis();
			
			Object result = method.invoke(service, arguments);

			String str = new StringJoiner(" ")
				.add("Method")
				.add(method.getName())
				.add("executed in")
				.add(String.valueOf(System.currentTimeMillis() - startTime))
				.add("millis.")
				.toString();
			
			System.out.println(str);

			return result;
		});
	
		proxyService.helloWorld();
	}
}
