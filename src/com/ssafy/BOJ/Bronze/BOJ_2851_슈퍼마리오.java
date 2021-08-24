package com.ssafy.BOJ.Bronze;

import java.util.Scanner;

public class BOJ_2851_슈퍼마리오 {
	public static void main(String[] args) {
		int[] sum = new int[11];
		
		Scanner sc = new Scanner(System.in);
		for (int i=1; i<=10; i++) {
			sum[i] = sum[i-1] + sc.nextInt();
		}
		
		for (int i=1; i<=10; i++) {
			if (sum[10] < 100) {
				System.out.println(sum[10]);
				break;
			}
			else if (sum[i]>=100) {
				int pre = Math.abs(100-sum[i-1]);
				int curr = Math.abs(100-sum[i]);
				System.out.println(pre<curr? sum[i-1]:sum[i]);
				break;
			} 
		}
	}
}
