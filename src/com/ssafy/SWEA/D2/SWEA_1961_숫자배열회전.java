// 숫자 배열 회전

package com.ssafy.SWEA.D2;

import java.util.Scanner;


/*
(Runtime error)
Error Message:
Memory error occured, 
(e.g. segmentation error, memory limit Exceed, stack overflow,... etc)


error : sc.nextLine(); 때문에 런타임 에러 발생
=> sc.next 로 입력 받으면 한 칸씩 입력을 받을 수 있어서 , ,, ,,,,,,
굳이 한 줄을 더 안 받아도 됨!

*
*
*/

public class SWEA_1961_숫자배열회전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int n = sc.nextInt();
			
			String[][] nums = new String[n][n];
			
			for (int row = 0; row < n; row++) {
				for (int col=0; col < n; col++) {
					nums[row][col] = sc.next().trim();
				}
			}
			
			String[][] result = new String[n][3];
			
			for (int col=0; col<3; col++) {
				for (int row=0; row<n; row++) {
					String temp = "";
					if (col==0) {
						for (int i = n-1; i >= 0 ; i--) {
							temp += nums[i][row];
						}
					} else if (col==1) {
						for (int j = n-1; j >= 0 ; j--) {
							temp += nums[n-row-1][j];
						}
					} else if (col==2) {
						for (int k = 0; k < n ; k++) {
							temp += nums[k][n-row-1];
						}
					}
					result[row][col] = temp;
				}
			}
			
			System.out.println("#"+t);
			for (String[] row:result) {
				for (String col:row) {
					System.out.print(col+ " ");
				}
				System.out.println();
			}
		}
	}
}

/*
 * 
10
3
1 2 3
4 5 6
7 8 9
*/
