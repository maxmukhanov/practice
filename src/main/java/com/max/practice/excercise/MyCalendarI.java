package com.max.practice.excercise;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarI {
    private TreeMap<Integer, Integer> cal = new TreeMap<>();

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floor = cal.floorEntry(start);
        Map.Entry<Integer, Integer> ceiling = cal.ceilingEntry(start);

        if ((floor == null || floor.getValue() <= start) && (ceiling == null || ceiling.getKey() >= end)) {
            cal.put(start, end);
            return true;
        }

        return false;
    }

    public int size() {
        return cal.size();
    }
}
