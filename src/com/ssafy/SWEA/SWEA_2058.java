//자릿수 더하기

package com.ssafy.SWEA;

import java.util.Scanner;


public class SWEA_2058 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
		int sum = 0;
		
		for (int i = 0 ;i < n.length() ; i++) {
			sum += n.charAt(i)-'0';
		}
		System.out.println(sum);
	}
}
