//간단한 359 게임

package com.ssafy.SWEA.D2;

import java.util.Scanner;

public class SWEA_1926_간단한369게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			boolean flag = true;
			char[] s = (Integer.toString(i)).toCharArray();
			for (int j=0; j<s.length; j++) {
				int curr = s[j] - '0';
				if (curr!= 0 & curr % 3 == 0) {
					System.out.print('-');
					flag = false;
				}
			}
			if (flag) {
				System.out.print(i+" ");
			} else {
				System.out.print(" ");
			}
		}
	}
}
