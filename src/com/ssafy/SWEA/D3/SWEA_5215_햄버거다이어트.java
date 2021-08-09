package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_햄버거다이어트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int max_cal = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[n+1][2];
			
			for (int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int score = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				
				arr[i] = new int[] {score, cal};
			}
			
			
			/*----------- 햄버거를 담지 않을 때를 고려하지 못하므로 그리디 알고리즘------------*/
//			// dp[i] = 칼로리의 합이 i일때 가질 수 있는 최대 점수
//			int[] dp = new int[max_cal+1];
//			
//			for (int i=1; i<=max_cal; i++) {
//				for (int j=0; j<n; j++) {
//					int curr_score = arr[j][0];
//					int curr_cal = arr[j][1];
//					
//					if (i < curr_cal) {
//						continue;
//					}
//					
//					dp[i] = Math.max(dp[i], dp[i-curr_cal] + curr_score);
//				}
//			}
//			
//			for (int num: dp) {
//				System.out.print(num+" ");
//			}
//			System.out.println();
//			System.out.println(dp[max_cal]);
			
			
			/*----------------- 냅색 알고리즘 --------------------*/
			int[][] dp = new int[n+1][max_cal+1];
			// dp[i][j] = 칼로리 합이 j일 때, 처음 i개의 햄버거로 가질 수 있는 최대 점수 
			
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=max_cal; j++) {
					int curr_score = arr[i][0];
					int curr_cal = arr[i][1];
					
					if (curr_cal <= j) {	// 현재 칼로리 <= 최대 칼로리 : 햄버거를 먹을 수 있을 때
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-curr_cal] + curr_score);
					}
					else {	// 현재 칼로리가 더 클 때 : 햄버거를 먹지 못할 때
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,dp[n][max_cal]);
		}
		
	}
}
