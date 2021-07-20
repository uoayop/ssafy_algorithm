// 알파벳을 숫자로 변환


package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_2050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		for (int i=0; i < str.length(); i++) {
			System.out.printf("%d ",str.charAt(i) - 64);
		}
	}
}
