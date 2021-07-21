// 파리 퇴치

package com.ssafy.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			sc.nextLine();
			for (int i=0; i<N; i++) {
				String[] row = (sc.nextLine()).split(" ");
				for (int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(row[j]);
				}
			}
			
			int answer = 0;
			
			for (int i=0; i <= N-M; i++) {
				for (int j=0; j <= N-M; j++) {
					int sum = 0;
					for (int k=0; k<M; k++) {
						for (int l=0; l<M; l++) {
							int nx = i + l;
							int ny = j + k;
							
							sum += arr[nx][ny];
						}
					}
					answer = Math.max(sum, answer);
				}
			}
			System.out.printf("#%d %d\n",t, answer);
		}
	}
}
