// [S/W 문제해결 기본] 1일차 - Flatten

package com.ssafy.SWEA.D3;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1208_1일차_Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int cnt = sc.nextInt();	// cnt만큼 dump 가능
			int[] width = new int[100];
			
			for (int i=0; i<100; i++) {
				width[i] = sc.nextInt();
			}
			
			Arrays.sort(width);	// 시작 전 정렬
			
			while (cnt-- > 0) {
				// [덤프할 수 있는 만큼 반복]
				// 가장 큰 값을 하나 줄이면서, 가장 작은 값을 하나 늘림
				// 값을 늘리고 줄였으므로 다시 정렬
				width[99]--;
				width[0]++;
				Arrays.sort(width);
			}
			
			System.out.printf("#%d %d\n", tc, width[99]-width[0]);
		}
	}
}


// 민동님 : 정렬말고 인덱스로 직접 변환 - 매번 정렬을 하는 건 별로다
// 재우님 : 우선순위큐 사용 - 지렸다
