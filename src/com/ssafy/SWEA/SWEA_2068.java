//중간 값 찾기


package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_2068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int i=1; i<=T; i++) {
			int max = 0;
			for (int j=0; j<10; j++) {
				int temp = sc.nextInt();
				if (max < temp) { max = temp; }
			}
			System.out.printf("#%d %d\n", i,max);
		}
	}
}
