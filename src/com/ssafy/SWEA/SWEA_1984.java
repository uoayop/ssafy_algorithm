//중간 평균값 구하기 

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		for (int t=1; t<=T; t++) {
			String[] nums = sc.nextLine().split(" ");
			
			int maxNum = Integer.MIN_VALUE;
			int minNum = Integer.MAX_VALUE;
			float sum = 0;
			for (String snum: nums) {
				int num = Integer.parseInt(snum);
				maxNum = Math.max(maxNum, num);
				minNum = Math.min(minNum, num);
				sum += num;
			}
			
			sum = sum - maxNum - minNum;
			System.out.printf("#%d %.0f\n",t, (float)sum/8);
		}
	}
}
