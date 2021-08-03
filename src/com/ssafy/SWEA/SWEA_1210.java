// [S/W 문제해결 기본] 2일차 - Ladder1

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_1210 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t=1; t<=10; t++) {
			int T = sc.nextInt();
			int[][] maps = new int[100][100];
			
			int x = 0, y = 0, nx =99, ny = 0;
			
			for (int i=0; i<100; i++) {
				for (int j=0; j<100; j++) {
					maps[i][j] = sc.nextInt();
					if (maps[i][j] == 2) {
						x = i; 
						y = j;
					}
				}
			}
			
			int[] dx = {0, 0, -1};
			int[] dy = {-1, 1, 0};	// 좌, 우, 위
			
			while (true) {
				if (x==0) {
					System.out.printf("#%d %d\n",t, y);
					break;
				}
				for (int i=0; i<3; i++) {
					nx = x + dx[i];
					ny = y + dy[i];
					
					if (0 <= nx && 0 < 100 && 0<= ny && ny < 100) {
						// 범위 내에 있을 때
						if (maps[nx][ny] == 1) {
							x = nx;
							y = ny;
							maps[nx][ny] = 0;
							break;
						}
					}
				}
			}
		}
	}
}
