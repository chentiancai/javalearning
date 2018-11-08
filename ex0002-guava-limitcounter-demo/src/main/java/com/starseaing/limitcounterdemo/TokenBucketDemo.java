package com.starseaing.limitcounterdemo;

import java.util.Random;

public class TokenBucketDemo {

	private static long time =System.currentTimeMillis();
	private static int createTokenRate = 3;
	private static int size = 20;
	//当前令牌数
	private static int tokens =20;
	
	public static boolean grant() {
		long now = System.currentTimeMillis();
		//在这段时间内需要产生的令牌数量
		int in = (int)((now - time)/50 * createTokenRate);
		tokens = Math.min(size, tokens + in);
		time = now;
		if(tokens>0) {
			-- tokens;
			return true;
		}else {
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
