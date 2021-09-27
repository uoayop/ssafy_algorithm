package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] weights = new int[n+1];
		int[] profits = new int[n+1];
		for (int i=1; i<=n; i++) {
			 st = new StringTokenizer(br.readLine());
			 weights[i] = Integer.parseInt(st.nextToken());
			 profits[i] = Integer.parseInt(st.nextToken());
		}
		
//		int[][] dp = new int[n+1][k+1];
//		for (int i=1; i<=n; i++) {
//			for (int j=1; j<=k; j++) {
//				if (weights[i] <= j) {
//					int currW = weights[i];
//					int currP = profits[i];
//					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-currW] + currP);
//				}
//				else {
//					dp[i][j] = dp[i-1][j];
//				}
//			}
//		}
//		System.out.println(dp[n][k]);
		
		int[] dp = new int[k+1];
		for (int i=1; i<=n; i++) {
			for (int j=k; j>=weights[i]; j--) {
				int currW = weights[i];
				int currP = profits[i];
				dp[j] = Math.max(dp[j], dp[j-currW] + currP);
			}
		}
		System.out.println(dp[k]);
	}
}
