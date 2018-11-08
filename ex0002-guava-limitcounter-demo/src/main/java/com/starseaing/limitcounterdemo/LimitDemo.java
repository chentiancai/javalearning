package com.starseaing.limitcounterdemo;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;

//参考链接https://www.cnblogs.com/fanguangdexiaoyuer/p/6253314.html
public class LimitDemo {

	public static ConcurrentHashMap<String,RateLimiter> resourceRateLimiter = 
			new ConcurrentHashMap<String,RateLimiter>();
	
	static {
		createResourceLimiter("order",10);
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 500; i++) {
			new Thread(new Runnable() {
				
				public void run() {
					//判断是否可以在指定的时间内从ratelimiter获得一个许可，或者在超时期间内未获得许可的话，立即返回false。
					if(resourceRateLimiter.get("order").tryAcquire(10, TimeUnit.MILLISECONDS)) {
						System.out.println("执行业务逻辑");
					}else {
						System.out.println("限流");
					}
				}
			}).start();
			Thread.sleep(new Random().nextInt(100));
		}

	}


	public static void createResourceLimiter(String resource, int qps) {
		if(resourceRateLimiter.containsKey(resource)) {
			resourceRateLimiter.get(resource).setRate(qps);
		}else {
			//创建具有指定稳定吞吐量的RateLimiter类，传入允许每秒提交的任务数量。
			RateLimiter rateLimiter = RateLimiter.create(qps);
			resourceRateLimiter.putIfAbsent(resource, rateLimiter);
		}	
	}

}
