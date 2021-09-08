package com.ssafy.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1592_영식이와친구들 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] ballCnt = new int[n+1];
		int curr = 1;
		int answer = 0;
		
		while (true) {
			ballCnt[curr] ++;
			if (ballCnt[curr] == m) { break; }

			answer ++;
			if (ballCnt[curr] % 2==0) {
				if (curr-l <= 0) curr = n-Math.abs(curr-l);
				else curr-=l;
			} else {
				if (curr + l > n) curr = (curr + l) % n;
				else curr += l;
			}
		}
		
		System.out.println(answer);
	}
}
