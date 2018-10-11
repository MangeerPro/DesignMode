package com.cocky.kit8develop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        for(String str: list) {
            System.out.println(str);
        }
        
        list.stream().filter((p)->p=="One").forEach((s)->System.out.println(s));
        Map<String,String> map = list.stream().collect(Collectors.toMap((String p)->p, (String p)->p));
        System.out.println(map.toString());
    }
}