package com.ssafy.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309_일곱난쟁이 {
	public static int n;
	public static int[] nanjangs, ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		nanjangs = new int[9];
		for (int i=0; i<9; i++) {
			nanjangs[i] = Integer.parseInt(br.readLine());
		}
		
		ans = new int[7];
		combination(0, 0);
	}

	private static void combination(int index, int cnt) {
		if (index == 7) {
			int hap = 0;
			for (int n: ans) {
				hap += n;
			}
			
			if (hap == 100) { 
				Arrays.sort(ans); 
				for (int n: ans) System.out.println(n);
			}
//			System.out.println(Arrays.toString(ans));
			
			return;
		}
		
		for (int i=cnt; i<9; i++) {
			ans[index] = nanjangs[i];
			combination(index+1, i+1);
		}
	}
}
