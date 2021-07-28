//간단한 소인수분해

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_1945 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int[] arr = new int[5];
			
			while (n>1) {
				if (n%2==0) {
					n/=2;
					arr[0]++;
				} else if (n%3==0) {
					n/=3;
					arr[1]++;
				}else if (n%5==0) {
					n/=5;
					arr[2]++;
				}else if (n%7==0) {
					n/=7;
					arr[3]++;
				}else if (n%11==0) {
					n/=11;
					arr[4]++;
				}
			}
			
			System.out.printf("#%d ",t);
			for (int num:arr) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}
}
