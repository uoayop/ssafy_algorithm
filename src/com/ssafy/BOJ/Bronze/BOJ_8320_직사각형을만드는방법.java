package com.ssafy.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_8320_직사각형을만드는방법 {
	public static int n, answer;
	public static int []arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[2];
		
		Combination(0, 1);
		System.out.println(answer);
	}

	private static void Combination(int index, int cnt) {
		if (index==2) {
			if (arr[0] * arr[1] <= n) {
				answer++;
				System.out.println(Arrays.toString(arr));
			}
			return;
		}
		
		for (int i=cnt; i<=n; i++) {
			arr[index] = i;
			Combination(index+1, i);
		}
	}
}
