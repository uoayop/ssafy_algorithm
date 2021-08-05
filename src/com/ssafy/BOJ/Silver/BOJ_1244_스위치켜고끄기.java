// 스위치 켜고 끄기

package com.ssafy.BOJ.Silver;

import java.util.Scanner;

public class BOJ_1244_스위치켜고끄기 {
	public static void toggle(int[] arr, int index) {
		arr[index] = arr[index] == 0? 1: 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 스위치 개수
		int[] status = new int[N+1];
		for (int i=1; i<=N; i++) {
			status[i] = sc.nextInt();
		}
		
		int PN = sc.nextInt(); 	// 학생 수
		for (int i=0; i<PN; i++) {
			int gender = sc.nextInt();
			int curr = sc.nextInt();
			
			if (gender == 1) {// 성별이 남성일때
				for (int j=curr; j <= N; j+= curr) {
					toggle(status, j);
				}
			} 
			else {	// 성별이 여성일 때
				int left = curr-1;
				int right = curr + 1;

				toggle(status, curr);
				while (left >= 1 && right <= N) {
					if (status[left] == status[right]) {
						toggle(status, left--);
						toggle(status, right++);
					} else break;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
	        System.out.print(status[i] + " ");
	        if (i % 20 == 0) {
	            System.out.println();
	        }
	    }
	}
}
