// 평균값 구하기


package com.ssafy.SWEA.D1;

import java.util.Scanner;

public class SWEA_2071_평균값구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			double sum = 0;
			for (int j = 0; j < 10; j++) {
				int temp = sc.nextInt();
				sum += temp;
			}
			System.out.printf("#%d %d\n",i,Math.round(sum/10));
		}

	}

}
