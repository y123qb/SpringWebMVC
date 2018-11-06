package com.cn.bbwt.concurrent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
 
/***
 * 利用闭锁countDownLatch 模拟并发请求
 * countDownLatch 实现原理是利用计数器原理，再初始化的时候设置线程的个数（主线程可以设置1）
 * 要执行任务的并发线程在run之前进入等待。当这个闭锁内的线程执行完后里面的数量会减1（countDown）
 * 直到减到0（主线程执行完毕），其他等待的线程开始一块执行。
 * 大体就是给所有线程设置了一道门。等所有线程到齐后，让主进程countDown到0，一键开启。所有线程并发执行
 * @author binger
 *
 */
public class CountDownLatchTest {
	
	public static int threadNum = 20;//创建的线程数量
	public static int requestNum = 100;//每个线程请求次数
	public static String url = "http://localhost:8082/creditScore";//请求地址
//	public static String url = "http://10.7.101.78:8081/creditScore";//请求地址
	
    public static void main(String[] args) throws InterruptedException {
        CountDownLatchTest latchTest = new CountDownLatchTest();
        Runnable thread = new ZzsdCreditScoreThread();//执行任务发请求的线程
        latchTest.beginTask(CountDownLatchTest.threadNum, thread);
    }
 
    public String beginTask(int threadNums, final Runnable runnable) throws InterruptedException {
    	//给当前进程设置一个闭锁，里面就他自己执行。其实就是设置了一个门，等待后面一键开启
    	final CountDownLatch mainThread = new CountDownLatch(1);
        final CountDownLatch taskThread = new CountDownLatch(threadNums);
        for(int i = 0; i < threadNums; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        // 使任务线程在此等待
                        mainThread.await();
                        try {
                        		runnable.run();
                        } finally {
                            // 将结束门减1，减到0时，就可以开启结束门了
                        	taskThread.countDown();
                        }
                    } catch (Exception ie) {
                        ie.printStackTrace();
                    }
                }
            };
            t.start();//开启任务线程
        }
        long startTime = System.nanoTime();//纳秒时间
        System.out.println(startTime + " [" + Thread.currentThread() + "] All thread is ready, concurrent going...");
        // 所有任务线程都准备好了，主线程执行（功能是创建任务线程）完减到0，开启任务门，所有线程一块涌入
        mainThread.countDown();
//       等结束门开启
        taskThread.await();
        long endTime = System.nanoTime();
        System.out.println(endTime + " [" + Thread.currentThread() + "] All thread is completed."+(endTime - startTime));
        return "success";
    }
}

