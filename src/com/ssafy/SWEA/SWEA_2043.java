//서랍의 비밀번호
package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_2043 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int p = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(p-k+1);
	}
}
