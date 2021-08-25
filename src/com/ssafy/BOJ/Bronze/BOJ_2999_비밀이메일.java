package com.ssafy.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2999_비밀이메일 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] string = br.readLine().toCharArray();
		
		int n = string.length;
		int r = 0, c = Integer.MAX_VALUE;
		for (int i=1; i<n; i++) {
			if (n % i == 0 && i < c) {
				r = i;
				c = n / i;
			}
		}
		
		int index = 0;
		char[][] arr = new char[c][r];
		for (int i=0; i<c; i++) {
			for (int j=0; j<r; j++) {
				arr[i][j] = string[index++];
			}
		}
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print(arr[j][i]);
			}
		}
	}
}
