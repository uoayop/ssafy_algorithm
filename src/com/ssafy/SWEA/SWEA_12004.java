// 구구단1

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_12004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int n = sc.nextInt();
			boolean result = false;
			
			for (int i=1; i<=9; i++) {
				for (int j=1; j<=9; j++) {
					if (n == i*j) {
						result = true;
						break;
					}
				}
			}
			
			if (result) System.out.printf("#%d Yes\n",t);
			else System.out.printf("#%d No\n",t);
		}
	}
}
