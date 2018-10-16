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
 
public class CountDownLatchTest {
 
    public static void main(String[] args) throws InterruptedException {
        Runnable taskTemp = new Runnable() {
 
            private int iCounter;
 
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    // 发起请求
//                    HttpClientOp.doGet("https://www.baidu.com/");
                    iCounter++;
                    System.out.println(System.nanoTime() + " [" + Thread.currentThread().getName() + "] iCounter = " + iCounter);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        };
 
        CountDownLatchTest latchTest = new CountDownLatchTest();
//        taskTemp = new ZzsdCreditScoreThread();
//        latchTest.startTaskAllInOnce(5, taskTemp);
        System.out.println(Double.valueOf("534.0").intValue());
    }
 
    public long startTaskAllInOnce(int threadNums, final Runnable runnable) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(threadNums);
        for(int i = 0; i < threadNums; i++) {
//        	Thread t = new Thread(runnable);
            Thread t = new Thread() {
                public void run() {
                    try {
                        // 使线程在此等待，当开始门打开时，一起涌入门中
                        startGate.await();
                        try {
                        		runnable.run();
                        } finally {
                            // 将结束门减1，减到0时，就可以开启结束门了
                            endGate.countDown();
                        }
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long startTime = System.nanoTime();
        System.out.println(startTime + " [" + Thread.currentThread() + "] All thread is ready, concurrent going...");
        // 因开启门只需一个开关，所以立马就开启开始门
        startGate.countDown();
        // 等等结束门开启
        endGate.await();
        long endTime = System.nanoTime();
        System.out.println(endTime + " [" + Thread.currentThread() + "] All thread is completed."+(endTime - startTime));
        return endTime - startTime;
    }
}

