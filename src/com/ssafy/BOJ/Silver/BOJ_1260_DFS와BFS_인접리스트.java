package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS_인접리스트 {
	static ArrayList<Integer> [] list;
	//static Node[] list;	// 정렬 ?.?
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int n = Integer.parseInt(st.nextToken());	// 정점 개수
		int m = Integer.parseInt(st.nextToken());	// 간선 개수
		int v = Integer.parseInt(st.nextToken());	// 시작되는 정점의 번호
		
		list = new ArrayList[n+1];
		for(int i=0; i <= n; i++){
			list[i] = new ArrayList();
        }
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);		// 방향 x
			list[to].add(from);
			
			Collections.sort(list[from]);	// 입력 받을 때마다 정렬
			Collections.sort(list[to]);
		}

		dfs(v, new boolean[n+1]);
		System.out.println();
		bfs(v, new boolean[n+1]);
	}

	private static void dfs(int curr, boolean[] visited) {
		System.out.print(curr+" ");
		visited[curr] = true;
		
		for (int temp: list[curr]) {
			if (!visited[temp]) {
				dfs(temp, visited);
			}
		}
	}
	
	private static void bfs(int start, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int v = q.poll();
			System.out.print(v+" ");
			
			for (int u: list[v]) {
				if (!visited[u]) {
					q.add(u);
					visited[u] = true;
				}
			}
		}
	}
}

  
