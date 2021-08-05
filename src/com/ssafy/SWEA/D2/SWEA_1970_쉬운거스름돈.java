// 쉬운 거스름돈

package com.ssafy.SWEA.D2;

import java.util.Scanner;

public class SWEA_1970_쉬운거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			int[] coins = {0, 0, 0, 0, 0, 0, 0, 0};
			// 50000, 10000, 5000, 1000, 500, 100, 50, 10

			int N = sc.nextInt();
			
			while (N>=10) {
				if (N>=50000) {
					coins[0] += N/50000;
					N %= 50000;
				} else if (N>=10000) {
					coins[1] += N/10000;
					N %= 10000;
				} else if (N>=5000) {
					coins[2] += N/5000;
					N %= 5000;
				} else if (N>=1000) {
					coins[3] += N/1000;
					N %= 1000;
				} else if (N>=500) {
					coins[4] += N/500;
					N %= 500;
				} else if (N>=100) {
					coins[5] += N/100;
					N %= 100;
				} else if (N>=50) {
					coins[6] += N/50;
					N %= 50;
				} else if (N>=10) {
					coins[7] += N/10;
					N %= 10;
				} 
			}
			
			System.out.println("#"+t);
			for (int coin:coins) {
				System.out.print(coin+" ");
			}
			System.out.println();
		}
	}
}
