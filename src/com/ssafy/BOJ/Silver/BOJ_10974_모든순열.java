package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974_모든순열 {
	static int n;
	static int[]nums;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		visited = new boolean[n+1];
		
		permutation(0);
	}

	private static void permutation(int cnt) {
		if (cnt==n) {
			for (int num:nums) {
				System.out.print(num+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i=1; i<=n; i++) {
			if (visited[i]) continue;
			
			nums[cnt] = i;
			visited[i] = true;
			permutation(cnt+1);
				
			visited[i] = false;
		}
	}
}
