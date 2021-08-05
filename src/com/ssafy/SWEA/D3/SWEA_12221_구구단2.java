// 구구단 2

package com.ssafy.SWEA.D3;

import java.util.Scanner;

public class SWEA_12221_구구단2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if (a>=10 || b>=10) {
				System.out.printf("#%d %d\n", t, -1);
			} else {
				System.out.printf("#%d %d\n", t, a * b);
			}
		}
	}
}
