// 날짜 계산기

package com.ssafy.SWEA.D2;

import java.util.Scanner;

public class SWEA_1948_날짜계산기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for(int t=1; t<=T; t++) {
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
			int answer = 0;
			
			for (int m = m1; m <= m2; m++) {
				if (m == m1) answer += (days[m] - d1 + 1);
				else if (m==m2) answer += d2;
				else answer += days[m];
			}
			System.out.printf("#%d %d\n",t,answer);
		}
	}
}
