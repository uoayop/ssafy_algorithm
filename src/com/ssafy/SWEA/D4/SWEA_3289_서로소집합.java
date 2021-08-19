package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuffer sb = new StringBuffer();
			int n = Integer.parseInt(st.nextToken());	// 원소의 개수
			int m = Integer.parseInt(st.nextToken());	// 연산의 개수
			
			int[] parent = make(n);
			
			sb.append("#").append(t).append(" ");
			for (int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int order = Integer.parseInt(st.nextToken());	// 연산의 종류
				int a = Integer.parseInt(st.nextToken());	// a
				int b = Integer.parseInt(st.nextToken());	// a
				
				if (order==0) {
					// 합집합 연산 수행
					union(parent, a, b);
				} else if (order==1) {
					if (isSameRoot(parent, a,b)) sb.append("1");
					else sb.append("0");
				}
			}
			System.out.println(sb.toString());
		}
	}

	private static boolean isSameRoot(int[] parent, int a, int b) {
		int aRoot = find(parent, a);
		int bRoot = find(parent, b);
		if (aRoot == bRoot) return true;
		return false;
	}
	
	private static boolean union(int[] parent, int a, int b) {
		int aRoot = find(parent, a);
		int bRoot = find(parent, b);
		if (aRoot == bRoot) return false;
		
		// a의 depth 가 더 낮으면,,?
		if (aRoot < bRoot) parent[aRoot] = bRoot;
		else parent[bRoot] = aRoot;
		return true;
	}

	private static int find(int[] parent, int a) {
		if (a==parent[a]) return a;
		return parent[a] = find(parent, parent[a]);
	}

	private static int[] make(int n) {
		int[] parent = new int[n+1];
		for (int i=1; i<=n; i++) {
			parent[i] = i;
		}
		return parent;
	}
}
