//홀수만 더하기

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_2072 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) { 
			int sum = 0;
			for (int j = 0; j < 10; j++) {
				int temp = sc.nextInt();
				if (temp % 2 == 1) {
					sum += temp;
				}
			}
			System.out.printf("#%d %d\n", i, sum);
		}
	}

}
