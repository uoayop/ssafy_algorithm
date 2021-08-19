package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {
	public static class edge implements Comparable<edge>{
		int start, end, weight;

		public edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(edge o) {
			return Integer.compare(weight, o.weight);
		}
	}
	
	public static int[] parent;
	
	private static void make() {
		parent = new int[v+1];
		for (int i=1; i<=v; i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int a) {
		if (a==parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	public static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		if (aR == bR) return false;
		
		if (aR < bR) parent[aR] = bR;
		else parent[bR] = aR;
		return true;
	}
	
	public static int v, e;
	public static edge[] list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		list = new edge[e];	// 간선의 개수만큼
		
		for (int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[i] = new edge(from, to, w);
		}
		
		Arrays.sort(list);
		make();
		
		int cnt = 0, result = 0;
		// cnt: 연결된 정점 개수, result: MST의 가중치 
		// 지금 list는 가중치가 오름차순으로 정렬되어 있음
		for (edge e: list) {
			if (union(e.start, e.end)) {
				result += e.weight;
				if (++cnt == v-1) break;
			}
		}
		
		System.out.println(result);
	}

	
}
