package com.ssafy.SWEA.D2;

import java.util.Scanner;

public class SWEA_1284_수도요금경쟁 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			// A사 1리터당 P원
			// B사 기본 요금 Q (R리터 이하) / 초과 시 1리터당 S원  
			int p = sc.nextInt();
			int q = sc.nextInt();
			int r = sc.nextInt();
			int s = sc.nextInt();
			int w = sc.nextInt();
			
			int A = w * p;
			int B = (w>r)? q + (w-r) * s : q;
			
			System.out.printf("#%d %d\n",t,Math.min(A, B));
		}
	}
}
