// 시각 덧셈

package com.ssafy.SWEA.D2;

import java.util.Scanner;

public class SWEA_1976_시각덧셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int h1 = sc.nextInt();
			int m1 = sc.nextInt();
			int h2 = sc.nextInt();
			int m2 = sc.nextInt();
			
			int h = h1 + h2;
			int m = m1 + m2;
			
			if (m >= 60) {
				h += m / 60;
				m %= 60;
			}
			if (h > 12) {
				h -= 12;
			}
			
			System.out.printf("#%d %d %d\n",t, h, m);
		}
		
	}
}
