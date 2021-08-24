package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결 {
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
			// 가중치에 따라 오름차순으로 정렬
			return Integer.compare(weight, o.weight);
		}
	}
	
	public static int[] parent;
	
	public static void make() {
		parent = new int[n+1];
		for (int i=1; i<=n; i++) {
			parent[i] = i;
		}
	}
	
	public static int find(int a) {
		if (a==parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	public static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		
		if (aR==bR) return false;
		
		if (aR < bR) parent[aR] = bR;
		else parent[bR] = aR;
		return true;
	}
	
	public static int n, m;
	public static edge[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new edge[m];
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[i] = new edge(from,to,w);
		}
		
		Arrays.sort(list);
		make();
	
		int cnt = 0, result = 0;
		for (edge e: list) {
			if (union(e.start, e.end)) {
				result += e.weight;
				if (++cnt == n-1) break;
			}
		}
		System.out.println(result);
	}
}
