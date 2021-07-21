// 패턴 마디의 길이

package com.ssafy.SWEA;

import java.util.Scanner;

public class SWEA_2007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1; t <= T; t++) {
			int answer = 0;
			
			String str = sc.next();
		
			for (int i = 1; i <= 10 ; i++) {
				String curr = str.substring(0,  i);
				String nxt = str.substring(i, 2 * i);
				
				if (curr.equals(nxt)) {
					answer = curr.length();
					break;
				}
			}
			System.out.printf("#%d %d\n", t, answer);
		}
	}
}
