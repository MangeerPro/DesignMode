package com.ccoky.automic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocalTest {
	private static final ThreadLocal<Map<String, String>> resource = new ThreadLocal<>();
	private static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();
}
