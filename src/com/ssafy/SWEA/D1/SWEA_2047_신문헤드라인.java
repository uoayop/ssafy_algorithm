//신문 헤드라인

package com.ssafy.SWEA.D1;

import java.util.Scanner;

public class SWEA_2047_신문헤드라인 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		for (int i=0; i<str.length(); i++) {
			if (96 < str.charAt(i) && str.charAt(i) < 123) {
				System.out.printf("%c",str.charAt(i)-32);
			} else {
				System.out.printf("%c",str.charAt(i));
			}
		}
		System.out.println();
	}
}
