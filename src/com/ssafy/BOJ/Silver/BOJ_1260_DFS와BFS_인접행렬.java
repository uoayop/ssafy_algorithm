package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_1260_DFS와BFS_인접행렬 {
	static boolean[][] map;
	static int n,m,v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());	// 정점 개수
		m = Integer.parseInt(st.nextToken());	// 간선 개수
		v = Integer.parseInt(st.nextToken());	// 시작되는 정점의 번호
		
		map = new boolean[1001][1001];	// 정점의 개수 최대 1000개
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map[from][to] = map[to][from] = true;	// 방향 x
		}

		dfs(v, new boolean[n+1]);
		System.out.println();
		bfs(v, new boolean[n+1]);
	}

	private static void dfs(int curr, boolean[] visited) {
		System.out.print(curr+" ");
		visited[curr] = true;
		
		for (int i=0; i<=n; i++) {	// 번호가 작은 순서대로 방문!
			if (!visited[i] && map[curr][i]) {
				dfs(i, visited);
			}
		}
	}
	
	private static void bfs(int start, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while (!q.isEmpty()){
			int v = q.poll();
			System.out.print(v+" ");
			
			for (int i=0; i<=n; i++) {
				if (map[v][i] && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
