package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {
	public static class node implements Comparable<node>{
		int to;
		long price;

		public node(int to, long dijk) {
			this.to = to;
			this.price = dijk;
		}

		@Override
		public int compareTo(node o) {
			return (int) (price-o.price);
		}
	}
	
	public static ArrayList<node>[] list;
	public static long[] dijk;
	public static boolean[] visited;
	public static int n, m, start, end;
	public final static long MAXNUM = 10000000001l;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		for (int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			list[from].add(new node(to,price));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijskra();
		System.out.println(dijk[end]);
	}

	private static void dijskra() {
		PriorityQueue<node> q = new PriorityQueue<>();
		q.add(new node(start,0));
		
		dijk = new long[n+1];
		Arrays.fill(dijk, MAXNUM);
		dijk[start] = 0;
		
		visited = new boolean[n+1];
		
		while (!q.isEmpty()) {
			node currNode = q.poll();
			int curr = currNode.to;
			
			if (visited[curr]) continue;
			visited[curr] = true;
			
			for (node n:list[curr]) {
				int next = n.to;
				long nextP = n.price;
				
				if (dijk[next] > dijk[curr] + nextP) {
					dijk[next] = dijk[curr] + nextP;
					q.add(new node(next, dijk[next]));
				}
			}
		}
	}
}
