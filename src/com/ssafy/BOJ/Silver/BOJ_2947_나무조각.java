package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2947_나무조각 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] woods = new int[5];
		for (int i=0; i<5; i++) {
			woods[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] answer = {1, 2, 3, 4, 5};
		
		while (!Arrays.equals(woods,answer)) {
			for (int i=0; i<4; i++) {
				if (woods[i] > woods[i+1]) {
					int temp = woods[i];
					woods[i] = woods[i+1];
					woods[i+1] = temp;
					print(woods);
				}
			}
		}
	}

	private static void print(int[] woods) {
		for (int w:woods) {
			System.out.print(w+" ");
		}
		System.out.println();
	}
}
