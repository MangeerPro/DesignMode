package com.ccoky.automic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocalTest {
	private static final ThreadLocal<Map<String, String>> resource = new ThreadLocal<>();
	private static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();
	private Lock lock = new ReentrantLock();
	private ThreadPoolExecutor executor = Executors.newScheduledThreadPool(corePoolSize)
}
