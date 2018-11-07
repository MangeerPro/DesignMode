package com.cocky.kit8develop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamCon {
	private void StreamCollections() {
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "19");
		map.put("2", "20");
		
//		map.stream();
		List<String> lst = new ArrayList<>();
		lst.add("One");
		lst.add("Two");
		lst.forEach(str ->{
			System.out.println(str);
		});
		Set<String> set = new HashSet<>();
		set.add("Three");
		set.add("Four");
		set.removeIf(str -> str == "Three");
		
		Map<String, String> safeMap = Collections.synchronizedMap(new HashMap());
		safeMap = lst.stream().collect(Collectors.toMap(p->p, p->p));
		
	}

}
