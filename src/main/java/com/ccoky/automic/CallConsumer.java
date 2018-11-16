package com.ccoky.automic;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CallConsumer implements Callable<Integer> {
	private int[] arrs;
	private AtomicInteger arrSize;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		Integer index = 0;
		if(arrSize.get() >= 0) {
			System.out.println(arrs[arrSize.get()]);
			index = arrSize.getAndDecrement();	
		}
		return index;
	}

	public int[] getArrs() {
		return arrs;
	}

	public void setArrs(int[] arrs) {
		this.arrSize = new AtomicInteger(arrs.length-1);
		this.arrs = arrs;
	}
	
}
