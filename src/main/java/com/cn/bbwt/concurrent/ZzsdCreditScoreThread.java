package com.cn.bbwt.concurrent;

import java.util.concurrent.CountDownLatch;

public class ZzsdCreditScoreThread implements Runnable{
	 final CountDownLatch startGate = new CountDownLatch(1);
	private int num;
	
	@Override
	public   void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (this) {
				num++;
				System.out.println("纳秒时间"+System.nanoTime()+"["+Thread.currentThread().getName()+"] num="+num);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
