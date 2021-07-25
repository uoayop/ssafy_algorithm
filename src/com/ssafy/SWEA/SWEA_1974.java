// 스도쿠 검증

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_1974 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1;t<=T; t++) {
			boolean result = true;
			int[][] puzzle = new int[9][9];
					
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			
			for (int i=0; i<9; i++) {
				if (result == false) break;
				
				int[] col = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				int[] row = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				
				for (int j=0; j<9; j++) {
					col[puzzle[i][j]]++;
					row[puzzle[j][i]]++;
				}
				
				for (int check:col) {
					if (check==0 || check>1) result = false;
				}
				
				for (int check:row) {
					if (check==0 || check>1) result = false;
				}
			}
			
			for (int i=0; i<9; i+=3) {
				if (result==false) break;
				
				int[] box = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				for (int j=i; j<i+3; j++) {
					for (int k=i; k<i+3; k++) {
						box[puzzle[j][k]] ++;
					}
				}
				
				for (int check:box) {
					if (check==0 || check>1) result = false;
				}
			}
			
			if (result) System.out.printf("#%d %d\n",t, 1);
			else System.out.printf("#%d %d\n",t,0);
		}
	}
}
