package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_1983 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			// 학생 수 N, 학생 번호 K
			int N = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			
			float[] scores = new float[N];
			String[] result = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
			for (int i=0; i<N; i++) {
				String[] row = sc.nextLine().split(" ");
				for (int j=0; j<3; j++) {
					int curr = Integer.parseInt(row[j]);
					if (j==0) {
						scores[i] += (float)curr * 0.35;
					} else if (j==1) {
						scores[i] += (float)curr * 0.45;
					} else {
						scores[i] += (float)curr * 0.2;
					}
				}
			}
			
			float target = scores[K-1];
			int cnt = 0;
			for (float x: scores) {
				if (x > target) cnt ++;
			}
			
			System.out.printf("#%d %s\n", t, result[cnt/(N/10)]);
		}
	}
}
