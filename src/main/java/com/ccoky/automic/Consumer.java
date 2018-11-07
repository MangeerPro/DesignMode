package com.ccoky.automic;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {
	private ThreadLocal<Map> source = new ThreadLocal<>();
	
	private int[] intArrs = {};
	private static AtomicInteger intArrsSize = new AtomicInteger(0);
	private CountDownLatch downLatch;
	private CountDownLatch await;

	private Lock lock = new ReentrantLock();
	
	
	public Consumer() {
		super();
	}

	public Consumer(CountDownLatch downLatch, CountDownLatch await) {
		this.downLatch = downLatch;
		this.await = await;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(intArrsSize.get() >= 0) {
			try {
				lock.lock();
				downLatch.await();
				System.out.println(Thread.currentThread().getName() +"|"+ intArrs[intArrsSize.get()]);
				intArrsSize.decrementAndGet();
				await.countDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}


	public int[] getIntArrs() {
		return intArrs;
	}


	public void setIntArrs(int[] intArrs) {
		this.intArrsSize = new AtomicInteger(intArrs.length-1);
		this.intArrs = intArrs;
	}

	
}
