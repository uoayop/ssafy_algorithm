// 어디에 단어가 들어갈 수 있을까

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			// 가로 세로 길이 N / 단어의 길이 K
			int N = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			
			int[][] arr = new int[N][N];
			
			for (int i=0; i<N; i++) {
				String[] row = sc.nextLine().split(" ");
				for (int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(row[j]);
				}
			}
			
			int sum = 0;
	
			for (int i=0; i<N; i++) {
				int colcnt = 0;
				int rowcnt = 0;
				boolean colflag = false;
				boolean rowflag = false;
				for (int j=0; j<N; j++) {
					// 흰색 부분 1, 검은색 부분 0
					if (arr[i][j] == 1) {
						rowcnt ++;
					} else {
						if (rowcnt == K) { sum++; }
						rowcnt = 0;
					}
					
					if (arr[j][i] == 1) {
						colcnt ++;
					} else {
						if (colcnt == K) { sum++; }
						colcnt = 0;
					}
				}
				if (rowcnt == K) {sum ++;}
				if (colcnt == K) {sum ++;}
			}
			System.out.printf("#%d %d\n", t, sum);
		}
	}
}
