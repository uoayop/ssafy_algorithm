package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {
	public static int[][] map, nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		nums = new int[5][5];
		
		for (int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				cnt++;
				int num = nums[i][j];
				if (BingoCheck(num) == 3) {
					System.out.println(cnt);
					return;
				}
			}
		}
	}

	private static int BingoCheck(int num) {
		int cnt = 0;
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
			if (map[i][j] == num) {
					map[i][j] = -1;
					break;
				}
			}
		}
	
		for (int i = 0; i < 5; i++) {
			boolean bingo = true;
			for (int n: map[i]) {
				if (n != -1) { bingo = false; break; } 
			}
			if (bingo) cnt++;
		}
//		System.out.println("가로 검사: "+cnt);
		
		for (int i = 0; i < 5; i++) {
			boolean bingo = true;
			for (int j=0; j<5; j++) {
				if (map[j][i] != -1) { bingo = false; break; } 
			}
			if (bingo) cnt++;
		}
//		System.out.println("세로 검사: "+cnt);
		
		for (int i=0; i<2; i++) {
			boolean bingo = true;
			for (int j=0; j<5; j++) {
				if (i==0) {
					if (map[j][j] != -1) { bingo = false; break; } 
				}
				else {
					if (map[j][5-j-1] != -1) { bingo = false; break; } 
				}
			}
			if (bingo) cnt++;
		}
//		System.out.println("대각선 검사: "+cnt);
		

//		for (int[] row: map) {
//			for (int col:row) {
//				System.out.printf("%2d ",col);
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		return cnt;
	}
}
