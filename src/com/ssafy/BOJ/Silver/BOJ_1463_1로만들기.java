package com.ssafy.BOJ.Silver;

import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int[] d = new int[x+1];
		
		/* d[i] = i를 1로 만들 때 연산을 사용하는 횟수
		 * 
		 * d[1] = 0
		 * d[2] = 2 - 1 = 1 or 2 / 2 = 1
		 * => d[1] + 1
		 * 
		 * d[3] = 3 / 3 = 1 or 3 - 1 - 1 = 1
		 * => d[2] + 1 / d[1] + 1
		 * ...
		 * 
		 * */
		for (int i = 2; i <= x; i++) {
			d[i] = d[i-1] + 1;
			if (i % 2 == 0) d[i] = Math.min(d[i], d[i/2] + 1);
			if (i % 3 == 0) d[i] = Math.min(d[i], d[i/3] + 1);
		}
		System.out.println(d[x]);
	}
}
