package com.ccoky.automic;

import java.util.concurrent.CountDownLatch;

public class Main {

	public static void main(String[] args) {
		CountDownLatch downLatch = new CountDownLatch(2);
		CountDownLatch await = new CountDownLatch(5);
		for(int i = 0; i < 5; i++) {
			new Thread(new Consumer(downLatch, await)).start();
		}
		System.out.println("用于触发等待状态线程开始工作");
		System.out.println("用于触发等待状态的线程工作完成，等待状态的线程开始工作");
	}
}