package com.ccoky.automic;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadPoolTest {
	public void test() {
		int[] intArrays = {1,2,3,5,6};
		//Runnable 消费数组
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(6);
		Consumer consumer = new Consumer();
		consumer.setIntArrs(intArrays);
		for(int i = 0; i < intArrays.length; i++) {
			newFixedThreadPool.execute(consumer);
		}
		
		//Callable消费数组，打印返回值
		CallConsumer callConsumer = new CallConsumer();
		callConsumer.setArrs(intArrays);
		Future<Integer> submit = newFixedThreadPool.submit(callConsumer);
		newFixedThreadPool.shutdown();
		try {
			System.out.println(submit.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Callable消费数组，结合FutureTask获取返回值
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		FutureTask<Integer> featureTask = new FutureTask<>(callConsumer);
		Future<?> result = newCachedThreadPool.submit(featureTask);
		newCachedThreadPool.shutdown();
		try {
			System.out.println(featureTask.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取返回值
		ExecutorService poolExecutor = 
				new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
		Integer resultVal = 100;
		consumer = new Consumer();
		consumer.setIntArrs(intArrays);
		FutureTask<Integer> task = new FutureTask<>(consumer, resultVal);
		poolExecutor.submit(task);
		try {
			System.out.println("return message: " + task.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExecutorService executor = Executors.newCachedThreadPool();
			Future<AtomicInteger> submit2 = executor.submit(()->{
				IntStream asList = Arrays.stream(intArrays);
				AtomicInteger atomici = new AtomicInteger(0);
				asList.forEach( set -> {
						System.out.println( Thread.currentThread().getName() +"||" + set);
						atomici.getAndIncrement();
				});	
				return atomici;
			});
			try {
				System.out.println(submit2.get().get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Thread thread = new Thread(consumer);
			UncaughtExceptionHandler uncaughtExceptionHandler =new UncaughtExceptionHandler() {
				
				@Override
				public void uncaughtException(Thread t, Throwable e) {
					// TODO Auto-generated method stub
					System.out.println("catch到了");
				}
			};
			thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
	}
}
