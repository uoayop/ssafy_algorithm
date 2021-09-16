package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// kruskal
public class SWEA_3124_최소스패닝트리 {
	public static class edge implements Comparable<edge>{
		int start, end, weight;

		public edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(edge o) {
			return Integer.compare(weight, o.weight);
		}
	}
	
	public static int[] parents; // 부모 원소 관리
	public static int[] rank; // 원소의 높이 관리
	
	public static void make() {
		parents = new int[v+1];
		rank = new int[v+1];
		for (int i=0; i<=v; i++) {
			// 모든 원소의 대표자 = 자신
			parents[i] = i;
			rank[i] = 0;
		}
	}
	
	public static int find(int a) {
		// a가 속한 집합의 대표자 찾기
		if (a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;	// 이미 같은 집합
		
		// 높이가 더 낮은 트리를 높이가 높은 트리 밑으로 넣음
		int minRoot = Math.min(aRoot, bRoot);
		parents[aRoot] = minRoot;
		parents[bRoot] = minRoot;
		
		return true;
	}
	
	public static int v, e;
	public static edge[] list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			list = new edge[e];
			for (int i=0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				list[i] = new edge(start, end, weight);
			}
			
			Arrays.sort(list);
			make();
			
			int cnt = 0;
			long result = 0;
			for (edge e: list) {
				if (union(e.start, e.end)) {
					result += e.weight;
					if (++cnt == v-1) break;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}


// prim 코드 작성 중!
//public class SWEA_3124_최소스패닝트리 {	
//	public static int v, e;
//	public static PriorityQueue<Integer>[] pq;
//	public static boolean[] visited;
//	public static int[] minEdge;
//	
//	public static class edge implements Comparable<edge>{
//		int start, end, weight;
//
//		public edge(int start, int end, int weight) {
//			this.start = start;
//			this.end = end;
//			this.weight = weight;
//		}
//
//		@Override
//		public int compareTo(edge o) {
//			return Integer.compare(weight, o.weight);
//		}
//
//		@Override
//		public String toString() {
//			return "edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
//		}
//	}
//	
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		
//		for (int t=1; t<=T; t++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			v = Integer.parseInt(st.nextToken());
//			e = Integer.parseInt(st.nextToken());
//
//			PriorityQueue<edge>[] pq = new PriorityQueue[v+1];
//			for (int i=1; i<v+1; i++) {
//				pq[i] = new PriorityQueue<>();
//			}
//			
//			for (int i=0; i<e; i++) {
//				st = new StringTokenizer(br.readLine());
//				int start = Integer.parseInt(st.nextToken());
//				int end = Integer.parseInt(st.nextToken());
//				int weight = Integer.parseInt(st.nextToken());
//				pq[start].add(new edge(start,end,weight));
//			}
//			
//			visited = new boolean[v+1];
//			minEdge = new int[v+1];
//			Arrays.fill(minEdge, Integer.MAX_VALUE);
//			
//			int result = 0;
//			minEdge[0] = 0;
//			for (int i=0; i<v; i++) {
//				if (!pq[i].isEmpty()) {
//					edge minE = pq[i].poll();
//					visited[minE.end] = true;
//					result += minE.weight;
//				}
//			}
//		}
//	}	
//}


/*
1
3 3
1 2 1
2 3 2
1 3 3
*/