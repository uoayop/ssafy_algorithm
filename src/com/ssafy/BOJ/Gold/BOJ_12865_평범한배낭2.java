package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
		
		int[][] dp = new int[n+1][k+1];
		// dp[i][j] : i번째 물건까지 가방에 담아서 무게의 합이 j일 때 가질 수 있는 최대 가치
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=k; j++) {
				if (weights[i] <= j) {	//담을 수 있을 때
					int currW = weights[i];
					int currP = profits[i];
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-currW] + currP);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		bw.write(dp[n][k]+"\n");
		bw.flush();
	}
}
