package com.zhenghongfei.btracesamples.hellobean;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HelloBean {

	private long totalTimes;

	public boolean hello(int sleepTime) throws Exception {
		totalTimes = totalTimes + sleepTime;
		System.out.println("hello method sleep time is:" + sleepTime);
		TimeUnit.MILLISECONDS.sleep(sleepTime);
		return sleepTime > 500;
	}

	public static void main(String[] args) throws Exception {
		Random random = new Random();
		while (true) {
			HelloBean helloBean = new HelloBean();
			helloBean.hello(random.nextInt(1000));
			TimeUnit.MILLISECONDS.sleep(1000);
		}
	}
}