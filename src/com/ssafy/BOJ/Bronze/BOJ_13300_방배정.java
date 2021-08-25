package com.ssafy.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] student = new int[7][2];
		// row: 학년, col: 성별
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			student[y][s] ++;
		}
		
		int cnt = 0;
		for (int i=1; i<7; i++) {
			for (int j=0; j<2; j++) {
				if (student[i][j] > 0) {
					cnt += student[i][j] / k;
					if (student[i][j] % k > 0) cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
