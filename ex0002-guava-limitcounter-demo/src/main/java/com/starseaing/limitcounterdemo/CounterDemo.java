package com.starseaing.limitcounterdemo;

import java.util.Random;

public class CounterDemo {

	private static long timeStamp = System.currentTimeMillis();
	
	//限制为1s内限制100请求
	private static long limitCount = 10;
	private static long interval = 1000;
	
	private static long reqCount = 0;
	
	//允许
	public static boolean grant() {
		long now = System.currentTimeMillis();
		if(now < timeStamp + interval) {
			if(reqCount < limitCount) {
				++ reqCount;
				return true;
			}else {
				return false;
			}
		}else {
			timeStamp = System.currentTimeMillis();
			reqCount =0;
			return false;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 500; i++) {
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(new Random().nextInt(5000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(grant()) {
						System.out.println(Thread.currentThread().getName() + "执行业务逻辑");
					}else {
						System.out.println(Thread.currentThread().getName() + "限流");
					}					
				}				
			}).start();
		}
		Thread.sleep(new Random().nextInt(100));
	}
}
