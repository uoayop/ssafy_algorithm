// 두 개의 숫자열

package com.ssafy.SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1959_두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
		
			int[] a = new int[n];
			int[] b = new int[m];
			
			for (int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			
			for (int i=0; i<m; i++) {
				b[i] = sc.nextInt();
			}
			
			
			int answer = Integer.MIN_VALUE;
			
			if (n<m) {
				for (int i=0; i <= m-n; i++) {
					int[] newb = Arrays.copyOfRange(b, i, i+n);
					int sum = 0;
					for (int j=0; j<n; j++) {
						sum += (a[j] * newb[j]);
					}
					answer = Math.max(sum, answer);
				}
			} else {
				for (int i=0; i <= n-m; i++) {
					int[] newa = Arrays.copyOfRange(a, i, i+m);
					int sum = 0;
					for (int j=0; j<m; j++) {
						sum += (b[j] * newa[j]);
					}
					answer = Math.max(sum, answer);
				}
			}
			System.out.printf("#%d %d\n",t,answer);
		}
	}
}
