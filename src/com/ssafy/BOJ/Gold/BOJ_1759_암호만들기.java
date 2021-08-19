package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	public static ArrayList<Character> list;
	public static ArrayList<String> answer;
	public static char[] arr;
	public static boolean[] visited;
	public static int l,c;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
	
		list = new ArrayList<>();
		for (char ch: br.readLine().toCharArray()) {
			if (ch!=' ') list.add(ch);
		}
		
		Collections.sort(list);
//		System.out.println(list);  // [a, c, i, s, t, w]
		visited = new boolean[c];
		answer = new ArrayList<>();
		makeSubset(c-1, 0);
		
		Collections.sort(answer);
		for (String str: answer) {
			System.out.println(str);
		}
	}

	private static void makeSubset(int index, int cnt) {
		if (index==-1) {
			String temp = "";
			if (cnt==l) {
//				System.out.println(Arrays.toString(visited));
				for (int i=0; i<c; i++) {
					if (visited[i]) temp += list.get(i);
				}
			}
			
			int aeiou = 0, etc = 0;
			for (char c: temp.toCharArray()) {
				if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
					aeiou ++;
				} else {
					etc++;
				}
			}
			
			if (aeiou >= 1 && etc >=2) {
				answer.add(temp);
			}
			
			return;
		}
		
		visited[index] = false;
		makeSubset(index-1, cnt);
		visited[index] = true;
		makeSubset(index-1, cnt+1);
		
	}
}
