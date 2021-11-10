package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[][] colors = new int[n][3];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				colors[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n+1][3];
		// dp[i][0] = i번째 집을 빨간색으로 색칠했을 때 최소 비용
		// dp[i][1] = i번째 집을 초록색으로 색칠했을 때 최소 비용
		// dp[i][2] = i번째 집을 파란색으로 색칠했을 때 최소 비용
		dp[0] = Arrays.copyOf(colors[0], 3);
		for (int i=1; i<n; i++) {
			dp[i][0] = colors[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = colors[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = colors[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		bw.write(findMin(dp[n-1])+"\n");
		bw.flush();
	}

	private static int findMin(int[] arr) {
		int ret = arr[0];
		ret = Math.min(ret, arr[1]);
		ret = Math.min(ret, arr[2]);
		return ret;
	}
}
