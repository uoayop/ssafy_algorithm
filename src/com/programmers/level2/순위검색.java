package com.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 순위검색 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				solution(new String[] {
						"java backend junior pizza 150",
						"python frontend senior chicken 210",
						"python frontend senior chicken 150",
						"cpp backend senior pizza 260",
						"java backend junior chicken 80",
						"python backend senior chicken 50"},
						new String[] {
							"java and backend and junior and pizza 100",
							"python and frontend and senior and chicken 200",
							"cpp and - and senior and pizza 250",
							"- and backend and senior and - 150",
							"- and - and - and chicken 100",
							"- and - and - and - 150"
						})));
	}
	
	// 효율성 통과를 못해!!!!!!!!!!!
	// 지원자들을 순차적으로 검사 X : 딕셔너리 형태로 저장해야할듯
	public static HashMap<String, ArrayList<Integer>> developer = new HashMap<>();
	public static ArrayList<Integer> scorelist;
	
	public static int[] solution(String[] info, String[] query) {
		for (String row: info) {
			String[] col = row.split(" ");
			makeCombination("", col, 0);
			// 쿼리의 모든 경우를 고려하기 위해 조합 사용
		}

		List<String> keys = new ArrayList<>(developer.keySet());
		for (int i=0; i<developer.size(); i++) {
			List<Integer> scores = developer.get(keys.get(i));
			Collections.sort(scores);
			// 점수 오름차순 정렬
		}
    	
        int[] answer = new int[query.length];
        for (int i=0; i<query.length; i++) {
        	String[] col = query[i].split(" and ");
        	String food = col[3].split(" ")[0];
        	int score = Integer.parseInt(col[3].split(" ")[1]);
        	
        	String findStr = (new StringBuffer().append(col[0]).append(col[1]).append(col[2]).append(food)).toString();
        	
        	scorelist = new ArrayList<>();

        	if (developer.get(findStr) != null) {
        		scorelist = developer.get(findStr);
        	}
        	
        	answer[i] = binarysearch(score, scorelist);
        }
        
        return answer;
    }

	private static void makeCombination(String str, String[] col, int depth) {
		if (depth == 4) {
			if (!developer.containsKey(str)) {
				ArrayList<Integer> prices = new ArrayList<>();
				prices.add(Integer.parseInt(col[4]));
				developer.put(str, prices);
			}
			else {
				developer.get(str).add(Integer.parseInt(col[4]));
			}
			return;
		} 
		
		makeCombination(str+"-", col, depth+1);
		makeCombination(str+col[depth], col, depth+1);
	}

	private static int binarysearch(int score, ArrayList<Integer> list) {
		int left = 0, right = list.size();
		while (left < right) {
			int mid = (left + right) / 2;
			int value = list.get(mid);
			if (value < score) left = mid + 1;
			else right = mid;
		}
		return list.size() - left;
	}
}

/*
// -----------------------효율성 통과 못한 코드

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
	public static class man implements Comparable<man>{
		String language, job, career, food;
		int score;

		public man(String language, String job, String career, String food, int score) {
			this.language = language;
			this.job = job;
			this.career = career;
			this.food = food;
			this.score = score;
		}

		@Override
		public String toString() {
			return "man [language=" + language + ", job=" + job + ", career=" + career + ", food=" + food + ", score="
					+ score + "]";
		}

		@Override
		public boolean equals(Object obj) {
			man other = (man) obj;
			if (!career.equals(other.career) && !career.equals("-"))
				return false;
			if (!food.equals(other.food) && !food.equals("-"))
				return false;
			if (!job.equals(other.job) && !job.equals("-"))
				return false;
			if (!language.equals(other.language) && !language.equals("-"))
				return false;
			return true;
		}

		@Override
		public int compareTo(man o) {
			return score - o.score;
		}
	}
	
	public static ArrayList<man> developer = new ArrayList<>();
	public static ArrayList<Integer> scorelist;
	
	public static int[] solution(String[] info, String[] query) {
		for (String row: info) {
			String[] col = row.split(" ");
			developer.add(new man(col[0], col[1], col[2], col[3],Integer.parseInt(col[4])));
		}
		
		Collections.sort(developer);
		
        int[] answer = new int[query.length];
        for (int i=0; i<query.length; i++) {
        	String[] col = query[i].split(" and ");
        	String food = col[3].split(" ")[0];
        	int score = Integer.parseInt(col[3].split(" ")[1]);
        	man target = new man(col[0], col[1], col[2], food, score);
        	
        	scorelist = new ArrayList<>();
        	for (man find: developer) {
	    		if (target.equals(find)) { scorelist.add(find.score); }
	    	}
        	
        	answer[i] = binarysearch(score, scorelist);
        }
        
        return answer;
    }

	private static int binarysearch(int score, ArrayList<Integer> list)     {   
		int left = 0, right = list.size();
		while (left < right) {
			int mid = (left + right) / 2;
			int value = list.get(mid);
			if (value < score) left = mid + 1;
			else right = mid;
		}
		return list.size() - left;
	}
}
 */