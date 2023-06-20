package com.vitality.utillity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.Frequency;

public class Utils {
	public static List<Integer> parseList(String listParam) {
        String[] values = listParam.split(",");
        List<Integer> list = new ArrayList<>();
        for (String value : values) {
            list.add(Integer.parseInt(value));
        }
        return list;
    }

    public static double calculateMedian(List<Integer> list) {
        int size = list.size();
        double median;
        if (size % 2 == 0) {
            median = (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
        } else {
            median = list.get(size / 2);
        }
        return median;
    }

    public static Integer calculateMode(List<Integer> numbers) {
//        Map<Integer, Integer> frequencyMap = new HashMap<>();
//        int maxCount = 0;
//        int mode = 0;
//
//        for (int num : numbers) {
//            int count = frequencyMap.getOrDefault(num, 0) + 1;
//            frequencyMap.put(num, count);
//
//            if (count > maxCount) {
//                maxCount = count;
//                mode = num;
//            }
//        }
//
//        return mode;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;

        for (int value : numbers) {
            int frequency = frequencyMap.getOrDefault(value, 0) + 1;
            frequencyMap.put(value, frequency);
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        List<Integer> mode = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                mode.add(entry.getKey());
            }
        }

        if (mode.size() == 1) {
            return mode.get(0);
        } else {
            return null;
        }
    }
}
