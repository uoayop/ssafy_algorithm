// 원재의 메모리 복구하기

package com.ssafy.SWEA.D3;

import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t=1; t<=T; t++) {
			
			char[] arr = (sc.nextLine()).toCharArray();
			
			// 문자열의 첫번째 인덱스가 1이면 한번 바꾸고 시작
			// 0011 -> 첫번째 인덱스 0이므로 바꿀 필요 X
			// 100 -> 첫번째 인덱스가 1이므로 바꾸고 시작
			
			char curr = arr[0];
			int cnt = arr[0] - '0';
			
			for (int i=1; i<arr.length; i++) {
				// 이전 요소와 다르면 cnt++
				if (arr[i] != curr) {
					cnt++;
				}
				curr = arr[i];
			}
			
			System.out.printf("#%d %d\n",t,cnt);
		}
	}
}
