// 1대1 가위바위보

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_1936 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		boolean win = false; //a가 이기면 true
		
		if ((a==1 & b==3) | (a==2 & b==1) | (a==3 & b== 2)) {
			win = true;
		} 
		
		if (win) {
			System.out.println('A');
		} else {
			System.out.println('B');
		}
	}
}
