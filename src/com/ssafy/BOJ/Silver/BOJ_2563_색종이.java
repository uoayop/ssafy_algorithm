package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	// 색종이의 수 / 색종이 크기는 10 x 10
		int[][] papers = new int[101][101];
		int answer = 0;
		
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());	// x
			int y = Integer.parseInt(st.nextToken());	// y
			
			for (int xx=x; xx<x+10; xx++) {
				for (int yy=y; yy<y+10; yy++) {
					papers[xx][yy] = 1;
				}
			}
		}
		
		for (int x=1; x<=100; x++) {
			for (int y=1; y<=100; y++) {
				if (papers[x][y]==1) answer++;
			}
		}
		
		
		System.out.println(answer);
	}
}
