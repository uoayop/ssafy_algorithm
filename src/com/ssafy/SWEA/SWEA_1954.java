// 달팽이 숫자

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// 오른쪽 -> 아래 -> 왼쪽 -> 위
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for (int t=1 ; t<=T ; t++) {
			int n = sc.nextInt();
			
			int[][] arr = new int[n][n];
			int cnt = 1; int dir = 0;
			int x = 0; int y= 0;
			
			while (cnt <= n*n){
				// 범위 안에 있고
				if (0<=x && x<n && 0<=y && y<n)
					if (arr[x][y]==0) { // 숫자가 없으면 할당하고 +1
						arr[x][y] = cnt++;
						
						// 이동
						x += dx[dir];
						y += dy[dir];
					} else {
						x -= dx[dir];
						y -= dy[dir];
						
						// 방향 틀어
						dir += 1;
						dir %= 4;
						
						x += dx[dir];
						y += dy[dir];
					}
				else {
					x -= dx[dir];
					y -= dy[dir];
					
					// 방향 틀어
					dir += 1;
					dir %= 4;
					
					x += dx[dir];
					y += dy[dir];
				}
			} 
			
			System.out.printf("#%d\n",t);
			for (int[] row:arr) {
				for(int col:row) {
					System.out.print(col+" ");
				}
				System.out.println();
			}
			
		}
	}
}
