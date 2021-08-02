// Base64 Decoder

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_1928 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		for (int t=1; t<=T; t++) {
			char[] str = (sc.nextLine()).toCharArray();
			
			for (char c:str) {
				System.out.printf("%d ",(byte)c);
			}
		}
	}
}
