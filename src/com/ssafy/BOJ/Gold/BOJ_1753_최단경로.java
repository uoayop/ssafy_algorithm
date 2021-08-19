package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라
public class BOJ_1753_최단경로 {
	
	public static class edge implements Comparable<edge>{
		int end, weight;
		
		public edge(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(edge o) {
			return weight-o.weight;
		}
	}
	
	public static ArrayList<edge>[] list;	
	public static int[] dijk;				
	public static int v, e, start;			
	public static final int MAXNUM = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		dijk = new int[v+1];		// dijk[i] : 출발지에서 i번째 정점까지 이동할 수 있는 최단 거리
		list = new ArrayList[v+1];	// list[i] : 출발지가 i인 정점 리스트
		
		Arrays.fill(dijk, MAXNUM);	// 최단 거리를 구하기 위해서 가장 큰 숫자로 채워줌
		
		for (int i=1; i<=v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[from].add(new edge(to, w));
			// 도착지와 가중치를 저장해줌
		}
		
		dijkstra();
		
		for (int i=1; i<=v; i++) {
			if (dijk[i] == MAXNUM) {
				System.out.println("INF");
			} else {
				System.out.println(dijk[i]);
			}
		}
	}

	private static void dijkstra() {
		boolean[] visited = new boolean[v+1];
		
		PriorityQueue<edge> q = new PriorityQueue<>();
		q.add(new edge(start, 0));
		
		dijk[start] = 0;	// 출발지 -> 출발지에 대한 거리는 0
		
		
		while (!q.isEmpty()) {	// q가 빌 때까지 : 인접한 정점들을 모두 방문할 때까지
			edge currEdge = q.poll();
			int currV = currEdge.end;
			
			if (visited[currV]) continue;	// 이미 방문한 곳이면 다음 정점으로 넘어감
			visited[currV] = true;
			
			for (edge nextEdge: list[currV]) {	
				// 해당 정점을 방문한 뒤, 연결된 다른 정점들에 대해서 반복
				int nextV = nextEdge.end;
				int nextW = nextEdge.weight;
				
				if (dijk[nextV] > dijk[currV] + nextW) {	
					// 만약 다음 정점으로 이동하는 거리가  dijk에 저장되어 있는 값보다 작으면 갱신
					dijk[nextV] = dijk[currV] + nextW;
					q.add(new edge(nextV, dijk[nextV]));
				}
			}
		}
	}
}
