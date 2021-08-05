// 큰 놈 작은놈 같은 놈

package com.ssafy.SWEA.D1;

import java.util.Scanner;

public class SWEA_2070_큰놈작은놈같은놈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int i=1; i<=T; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			char answer;
			
			if (num1==num2) {
				answer = '=';
			} else if (num1 > num2) {
				answer = '>';
			} else {
				answer = '<';
			}
			System.out.printf("#%d %s\n",i,answer);
		}
	}
}
