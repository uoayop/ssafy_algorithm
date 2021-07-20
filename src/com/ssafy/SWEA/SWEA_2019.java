// 더블더블

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_2019 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int result = 1;
		for (int i=0; i<=n; i++) {
			System.out.printf("%d ", result);
			result *= 2;
		}
	}
}
