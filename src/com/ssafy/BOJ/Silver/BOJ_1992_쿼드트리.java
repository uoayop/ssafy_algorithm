package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	public static StringBuilder sb = new StringBuilder();
	public static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for (int i=0; i<n; i++) {
			char[] row = br.readLine().toCharArray();
			for(int j=0; j<n; j++) {
				map[i][j] = row[j] - '0';
			}
		}
		
		check(0, 0, n);
		System.out.println(sb.toString());
	}

	private static void check(int x, int y, int size) {
		if (isPossible(x,y,size)) {
			sb.append(map[x][y]);
			return;
		}

		int mid = size / 2;
		sb.append("(");
		
		check(x, y, mid);
		check(x, y+mid, mid);
		check(x+mid, y, mid);
		check(x+mid, y+mid, mid);
		
		sb.append(")");
		
	}

	private static boolean isPossible(int x, int y, int size) {
		int value = map[x][y];
		
		for (int i=x; i<x+size; i++) {
			for (int j=y; j<y+size; j++) {
				if (value!=map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
