package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
	public static class P implements Comparable<P>{
		int time;

		public P(int time) {
			this.time = time;
		}

		@Override
		public int compareTo(P o) {
			return time-o.time;
		}
	}
	
	public static P[] plist;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		plist = new P[n];
		for (int i=0; i<n; i++) {
			plist[i] = new P(Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(plist);
		
		int answer = 0, accumulate = 0;
		for (P p:plist) {
			accumulate += p.time;
			answer += accumulate;
		}
		System.out.println(answer);
	}
}
