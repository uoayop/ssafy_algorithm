//거꾸로 출력해 보아요

package com.ssafy.SWEA.D1;

import java.util.Scanner;

public class SWEA_1545_거꾸로출력해보아요 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i=n; i>=0; i--) {
			System.out.printf("%d ",i);
		}
	}
}
