// 간단한 압축 풀기

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_1946 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int n = sc.nextInt();
			Object[][] arr = new Object[n][2];
			for (int i=0; i<n; i++) {
				arr[i][0] = sc.next();
				arr[i][1] = sc.nextInt();
			}
			
			int width = 0;
			System.out.printf("#%d\n",t);
			for (int i=0; i<n; i++) {
				String chr = (String)arr[i][0];
				int cnt = (int)arr[i][1];
				
				for (int j=0; j<cnt; j++) {
					System.out.print(chr);
					width++;
					if (width==10) {
						System.out.println();
						width = 0;
					}
				}
			}
			System.out.println();
		}
	}
}
