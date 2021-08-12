package com.ssafy.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_3040_백설공주와일곱난쟁이 {
	public static boolean[] visited = new boolean[9];
	public static int[] nanjangs;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		nanjangs = new int[9];
		for (int i=0; i<9; i++) {
			nanjangs[i] = Integer.parseInt(br.readLine());
		}
		
		makeSubset(0,0);
	}

	private static void makeSubset(int index, int cnt) {
		if (index == 9) {
			if (cnt==7) {
				int hap = 0;
				for (int i=0; i<9; i++) {
					if (visited[i]) {
						hap+= nanjangs[i];
					}
				}
				if (hap == 100) {
					for (int i=0; i<9; i++) {
						if (visited[i]) {
							System.out.println(nanjangs[i]);
						}
					}
				}
			}
			return;
		}
		
		visited[index] = true;
		makeSubset(index+1, cnt+1);
		visited[index] = false;
		makeSubset(index+1, cnt);
	}
}
