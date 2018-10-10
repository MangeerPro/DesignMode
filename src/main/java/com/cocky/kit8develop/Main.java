package com.cocky.kit8develop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        for(String str: list) {
            System.out.println(str);
        }
        list.stream().filter((p)->p=="One");
    }
}