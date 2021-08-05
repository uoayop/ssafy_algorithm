// 몫과 나머지 출력하기

package com.ssafy.SWEA.D1;

import java.util.Scanner;

public class SWEA_2029_몫과나머지출력하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int i=1; i<=T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.printf("#%d %d %d\n", i, a/b, a%b);
		}
	}
}
