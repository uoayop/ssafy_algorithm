//N줄 덧셈

package com.ssafy.SWEA.D1;

import java.util.Scanner;

public class SWEA_2025_N줄덧셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 0;
		for (int i=1; i<=n; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
