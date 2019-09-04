package com.max.practice.excercise;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    private Map<String, Integer> keyMap = new HashMap<>();
    private Map<String, Integer> prefixMap = new HashMap<>();

    /** Initialize your data structure here. */
    public MapSum() {
        
    }
    
    public void insert(String key, int val) {
        if (keyMap.containsKey(key)) {
            Integer prevValue = keyMap.get(key);
            insertPrefix(key, val - prevValue);
        } else {
            insertPrefix(key, val);        
        }    
        keyMap.put(key, val);
    }
    
    public int sum(String prefix) {
        return prefixMap.getOrDefault(prefix, 0);
    }
    
    private void insertPrefix(String key, Integer val) {
        for(int i = 1; i <= key.length(); i++){
            String prefix = key.substring(0, i);
            
            Integer sum = prefixMap.getOrDefault(prefix, 0);
            prefixMap.put(prefix, sum + val);
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */