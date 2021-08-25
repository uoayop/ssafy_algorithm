package com.ssafy.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {
	public static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[1001][1001];
		for (int i=0; i<1001; i++) {
			Arrays.fill(map[i], -1);
		}
		int n = Integer.parseInt(br.readLine());
		
		for (int t=0; t<n; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for (int i=x; i<x+w; i++) {
				for (int j=y; j<y+h; j++) {
					map[i][j] = t;
				}
			}
		}
		
		int[] cnt = new int[n];
		for (int i=0; i<1001; i++) {
			for (int j=0; j<1001; j++) {
				int curr = map[i][j];
				if (-1 < curr && curr < n) {
					cnt[curr] ++;
				}
			}
		}
		
		for (int c: cnt) {
			System.out.println(c);
		}
	}
}
 