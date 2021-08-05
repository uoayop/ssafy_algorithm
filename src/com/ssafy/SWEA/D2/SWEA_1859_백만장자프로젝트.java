//백만 장자 프로젝트

package com.ssafy.SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1859_백만장자프로젝트 {
	// 3 5 9 --> 9 5 3
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			
			sc.nextLine();
			String[] row = sc.nextLine().split(" ");
			for (int i=0; i<row.length; i++) {
				nums[i]= Integer.parseInt(row[N-i-1]);
			}	// 거꾸로 저장
			
			//  만약 1 이 999,999 개 나오고 맨 마지막에 10000이 나온다면, 최종 결과는 9999 * 999,999 = 9,998,990,001 이 됩니다.
			// 이 수는 99억이 넘어가므로 integer 형 또는 unsigned integer 형으로는 표현할 수 없습니다.
			long answer = 0;
			int max = nums[0];
			for (int n: nums) {
				if (n < max) {
					answer += max - n;
				} else {
					max = n;
				}
			}
			System.out.printf("#%d %d\n",t,answer);
		}
	}
}
