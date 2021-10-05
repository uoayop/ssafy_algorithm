package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	public static int n, m, v, map[][];
	public static boolean[] visited;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = 1;
			map[to][from] = 1;
		}
		
		dfs(v, new boolean[n+1]);
		bw.write("\n");
		bfs(v, new boolean[n+1]);
		bw.write("\n");
		bw.flush();
	}

	private static void dfs(int curr, boolean[] visited) throws Exception {
		if (visited[curr]) return;
		
		visited[curr] = true;
		bw.write(curr+" ");
		
		for (int u=1; u<=n; u++) {
			if (map[curr][u]!=0 && !visited[u]) {
				dfs(u, visited);
			}
		}
	}
	
	private static void bfs(int curr, boolean[] visited) throws Exception {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		
		while (!q.isEmpty()) {
			int t = q.poll();
			bw.write(t+" ");
			
			for (int u=1; u<=n; u++) {
				if (map[t][u]!=0 && !visited[u]) {
					q.add(u);
					visited[u] = true;
				}
			}
		}
	}

}
