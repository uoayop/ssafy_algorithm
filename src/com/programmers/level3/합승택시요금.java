package com.programmers.level3;

import java.util.Arrays;

public class 합승택시요금 {
	public static int INF = 999;
	public static int [][] map, dp;
	
	public static void main(String[] args){
		System.out.println(solution(6, 4, 6, 2, new int[][] {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
	}
	
	public static int solution(int n, int s, int a, int b, int[][] fares) {
		init(n, fares);
		
		for (int[] row: map) {
			for (int col: row) {
				System.out.print(col+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int k=1; k<=n; k++) {
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
				}
			}
		}
		
		for (int[] row: map) {
			for (int col: row) {
				System.out.print(col+" ");
			}
			System.out.println();
		}
		
		int answer = 0;
		return answer;
	}

	private static void init(int n, int[][] fares) {
		map = new int[n+1][n+1];
		for (int i=0; i<=n; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}
		for (int[] row: fares) {
			map[row[0]][row[1]] = row[2];
			map[row[1]][row[0]] = row[2];
		}
	}
}
