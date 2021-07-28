// 가랏! RC카!

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_1940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int n = sc.nextInt();
			sc.nextLine();
			int answer = 0;
			int currV = 0;
			for (int i=0; i<n; i++) {
				// n번 입력 받을거임
				String inputs = sc.nextLine();
				char mode = inputs.charAt(0);
				if (mode == '1') {
					currV += inputs.charAt(2) - '0';
					answer += currV;
				} else if (mode == '2') {
					currV -= inputs.charAt(2) - '0';
					currV = currV > 0 ? currV : 0; 
					answer += currV;
				} else if (mode == '0') {
					answer += currV;
				}
			}
			System.out.printf("#%d %d\n",t,answer);
		}
		
	}
}
