package com.ssafy.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_3052_나머지 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] mod = new boolean[42];
		int cnt = 0;
		
		for (int i=0; i<10; i++) {
			int num = Integer.parseInt(br.readLine());
			if (!mod[num % 42]) { mod[num % 42] = true; cnt++;}
		}
		System.out.println(cnt);
	}
}
