// 시각 덧셈

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_1976 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		int T = sc.nextInt();
		
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
		
		System.out.printf("%d %d\n", h, m);
		
	}
}