//파스칼의 삼각형

package com.ssafy.SWEA.D2;

import java.util.Scanner;

public class SWEA_2005_파스칼의삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1; t <= T; t++) {
			int N = sc.nextInt();
			
			int[][] result = new int[N][];
			
			for (int i=0; i<N; i++) {
				result[i] = new int[i+1];
				
				for (int j=0; j<=i; j++) {
					if (0 <= j-1 && j+1 <= i) {
						result[i][j] = result[i-1][j-1] + result[i-1][j];
					} else {
						result[i][j] = 1;
					}
				}
			}
			
			System.out.printf("#%d\n", t);
			for (int[] row: result) {
				for (int num: row) {
					System.out.print(num + " ");
				}
				System.out.println();
			}
		}
	}
}
