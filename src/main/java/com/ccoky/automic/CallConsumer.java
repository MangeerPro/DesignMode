package com.ccoky.automic;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class CallConsumer implements Callable<Integer> {
	private int[] arrs;
	private AtomicInteger arrSize;
	
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
