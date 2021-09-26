package com.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class 메뉴리뉴얼 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2,3,4})));
		System.out.println(Arrays.toString(solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2,3,5})));
		System.out.println(Arrays.toString(solution(new String[] {"XYZ", "XWY", "WXA"}, new int[] {2,3,4})));

	}

    public static HashMap<String, Integer> cntMap;
	public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        boolean[] want = new boolean[11];
        cntMap = new HashMap<>();
        
        for (String order: orders) {
        	char[] ordered = order.toCharArray();
        	Arrays.sort(ordered);
        	
        	for (int c: course) {
        		if (c <= order.length()) {
        			combination(ordered, new char[c], c, 0, 0);
        		}
        		want[c] = true;
        	}
        }
        
        // https://devlog-wjdrbs96.tistory.com/138
        List<Map.Entry<String, Integer>> list = new ArrayList<>(cntMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>> () {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if (o1.getKey().length() == o2.getKey().length()) {
					// key 값 길이가 같다면 value가 큰 순서대로 정렬
					return o2.getValue() - o1.getValue();
				}
				// key 값 길이가 다르면 key 길이가 작은 순으로 정렬
				return o1.getKey().length() - o2.getKey().length();
			}
        });
        
        int[] maxLen = new int[11];
        for (Map.Entry<String, Integer> o:list) {
        	String k = o.getKey();
        	int v = o.getValue();
        	int len = k.length();
        	if (v > 1 && want[len]) {
        		if (v > maxLen[len]) { maxLen[len] = v; answer.add(k); }
        		else if (v == maxLen[len]) { answer.add(k); }
        		else continue;
        	}
        }

        Collections.sort(answer);
        for (String s: answer) System.out.println(s);
        return answer.toArray(new String[0]);
    }
	
	private static void combination(char[] order, char[] array, int end, int index, int cnt) {
		if (index == end) {
			String key = "";
			for (char c: array) {
				key += c;
			}
			if (cntMap.containsKey(key)) cntMap.put(key, cntMap.get(key) + 1);
			else cntMap.put(key, 1);
			return;
		}
		
		for (int i=cnt; i<order.length; i++) {
			array[index] = order[i];
			combination(order, array, end, index+1, i+1);
		}
	}
}
