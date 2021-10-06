package com.ssafy.CantSolving;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		// 구역의 개수 2 ~ 10 
		
		int[] people = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] map = new boolean[n+1][n+1];
		
		for (int from=1; from<=n; from++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			if (from == 0) continue;
			
			while (cnt-- > 0) {
				int to = Integer.parseInt(st.nextToken());
				map[from][to] = true;
				map[to][from] = true;
			}
		}
		
		// 부분집합으로 구역 선택
		// 1 ~ n/2
		for (int i=1; i<=n/2; i++) {
			makeSubset(map, new boolean[n+1], 1, 0, n, i);
		}
	}

	private static void makeSubset(boolean[][] map, boolean[] visited, int index, int cnt, int n, int r) {
		if (index == n+1) {
			if (cnt == r) {
				for (int i=1; i<=n; i++) {
					if (visited[i]) System.out.print(i+" ");
				}
				System.out.println();
			}
			return;
		}
		
		visited[index] = true;
		makeSubset(map, visited, index+1, cnt+1, n, r);
		visited[index] = false;
		makeSubset(map, visited, index+1, cnt, n, r);
	}
}
