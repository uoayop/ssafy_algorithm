//초심자의 회문 검사

package com.ssafy.SWEA.D2;

import java.util.Scanner;

public class SWEA_1989_초심자의회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			boolean flag = false;
			sc.nextLine();
			String str = sc.next();
			
			StringBuffer sb = new StringBuffer(str);
			String rev = sb.reverse().toString();
			
			for (int i=0; i<str.length(); i++) {
				if (str.charAt(i)!= rev.charAt(i)) {
					flag = true;
					break;
				}
			}
			
			if (flag) {
				System.out.printf("#%d 0\n",t);
			} else {
				System.out.printf("#%d 1\n",t);
			}
		}
	}
}
