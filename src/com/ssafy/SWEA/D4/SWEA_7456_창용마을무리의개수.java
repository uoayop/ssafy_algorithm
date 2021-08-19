package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_7456_창용마을무리의개수 {
	public static ArrayList<Integer>[] list;
	public static boolean[] visited;
	public static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			visited = new boolean[n+1];
			list = new ArrayList[n+1];
			for (int i=0; i<=n; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				
				list[p1].add(p2);
				list[p2].add(p1);
			}
			
			result = 0;
			for (int i=1; i<=n; i++) {
				if (dfs(i)) {result ++;}
			}
			System.out.println("#"+t+" "+result);
		}
	}

	private static boolean dfs(int i) {
		// i번째 사람
		if (visited[i]) return false;
		
		visited[i] = true;
		for (int next: list[i]) {
			dfs(next);
		}
		return true;
	}
}
