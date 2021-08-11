package com.ssafy.BOJ.Gold;

import java.util.Scanner;

public class BOJ_17406_배열돌리기4 {
	
	static class Data {//회전연산의 정보
		int r;
		int c;
		int s;

		public Data(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	
	private static int N;
	private static int M;
	private static int K;
		
	private static int[][] map;
	private static int[][] mapClone;
	
	private static Data[] arr;
	private static Data[] tempArr;
	private static boolean[] v; 
	private static int min;
	private static int result; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N + 1][M + 1];
		mapClone = new int[N + 1][M + 1];
		
		arr = new Data[K];
		tempArr = new Data[K];
		
		v = new boolean[K];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			arr[i] = new Data(r, c, s);
		}

		result = Integer.MAX_VALUE;
		min = Integer.MAX_VALUE;
		perm(0);
		System.out.println(result);
        sc.close();
	}

	private static void perm(int len) {
		if (len == K) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					mapClone[i][j] = map[i][j];
				}
			}			
			
			solve(); 

			result = Math.min(result, min);
			
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				tempArr[len] = arr[i];
				perm(len + 1);
				v[i] = false;
			}
		}
	}

	private static void solve() {
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < tempArr.length; i++) {
			arrRotate(tempArr[i]);
		}

		int sum = 0;
		for (int j = 1; j <= N; j++) {
			sum = 0;
			for (int k = 1; k <= M; k++) {
				sum += mapClone[j][k];
			}
			min = Math.min(sum, min);
		}
	}

	
	private static void arrRotate(Data d) {
		int R = d.r;
		int C = d.c;
		int S = d.s;
		
		for (int s = 1; s <= S; s++) {
			
			int prevV = -1;
			int initR = -1, initC = -1; 


			for (int r = R - s, c = C - s; c <= C + s; c++) {
				if (prevV == -1) {
					initR = r;
					initC = c;
					prevV = mapClone[r][c];
				} else {
					int temp = prevV;
					prevV = mapClone[r][c];
					mapClone[r][c] = temp;
				}
			}

			for (int r = R - s + 1; r <= R + s; r++) {
				int temp = prevV;
				prevV = mapClone[r][C + s];
				mapClone[r][C + s] = temp;
			}
			
			
			for (int c = C + s - 1; c >= C - s; c--) {
				int temp = prevV;
				prevV = mapClone[R + s][c];
				mapClone[R + s][c] = temp;
			}
			
			for (int r = R + s - 1; r >= R - s + 1; r--) {
				int temp = prevV;
				prevV = mapClone[r][C - s];
				mapClone[r][C - s] = temp;
			}
			
			mapClone[initR][initC] = prevV;
		}
	}
}