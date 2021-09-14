package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] prices = new int[n][3];
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			prices[i][0] = Integer.parseInt(st.nextToken());
			prices[i][1] = Integer.parseInt(st.nextToken());
			prices[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n][3];
		dp[0] = prices[0];
		
		for (int i = 1; i < n; i++) {
			for (int j=0; j<3; j++) {
				if (j==0) {
					dp[i][j] = prices[i][j] + Math.min(dp[i-1][1], dp[i-1][2]);
				} else if (j==1) {
					dp[i][j] = prices[i][j] + Math.min(dp[i-1][0], dp[i-1][2]);
				} else {
					dp[i][j] = prices[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
				}
			}
		}
		Arrays.sort(dp[n-1]);
		System.out.println(dp[n-1][0]);
	}
}

/*
그리디처럼 문제를 생각해서 풀면 안됨!
지금 최선의 선택이 나중에도 최선이라는 보장 X
3
1 20 30 
50 5 6 
9 3 7
*/