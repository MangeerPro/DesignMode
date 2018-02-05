package com.cocky.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Java中缓存的基本实现
 */
public class JavaCache {
    /**
     * 缓存数据的容器，定义成Map是方便访问，直接根据key就可以获取value的值
     * key选用String
     */
    private Map<String, Object> map = new HashMap<>();

    /**
     * 从缓存中获取值
     *
     * @param key 设置时的key值
     * @return key对应value的值
     */
    public Object getValue(String key) {
        //先从缓存中取值
        Object object = map.get(key);
        //判断容器中是否有值
        if (object == null) {
            //如果没有，去数据库或者文件中读取
            object = key + ",value";
            //把获取的值存储到缓存中去
            map.put(key, object);
        }
        //如果有值就直接返回使用了
        return object;
    }
}
