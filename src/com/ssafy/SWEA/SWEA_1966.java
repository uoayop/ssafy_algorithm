// 숫자를 정렬하자

package com.ssafy.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			
			for (int i=0;i<n;i++) {
				nums[i] = sc.nextInt();
			}
			sc.nextLine();
			
			Arrays.sort(nums);
			System.out.printf("#%d ",t);
			for (int num:nums) {
				System.out.printf("%d ",num);
			}
			System.out.println();
		}
	}
}
