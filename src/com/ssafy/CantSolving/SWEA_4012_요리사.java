package com.ssafy.CantSolving;

import java.util.Scanner;

public class SWEA_4012_요리사 {
	static boolean[] visited;
	static int R, N;
	static long sum;
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			N = sc.nextInt();
			R = N / 2 ;
			sum = Integer.MAX_VALUE;
			map = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			visited = new boolean[N];
			comb(0, 0);
			System.out.printf("#%d %d\n", test_case, sum);
		}
		
		sc.close();
	}
	
	static void comb(int cnt, int start) {
		if(cnt == R) {
			findMin();
			return;
		}
		
		for(int i = start ; i < N ; i++) {
			visited[i] = true;
			comb(cnt+1, i+1);
			visited[i] = false;
		}
	}
	
	static void findMin() {
		int first = 0, second = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(visited[i] && visited[j]) {
					first += map[i][j];
				} else if (!visited[i] && !visited[j]) {
					second += map[i][j];
				}
			}
		}
		sum = Math.min(sum, Math.abs(first-second));
	}

}
