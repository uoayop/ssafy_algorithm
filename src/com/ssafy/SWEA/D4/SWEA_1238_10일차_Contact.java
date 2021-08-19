package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_10일차_Contact {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc<=10; tc++) {
			Queue<int[]> q = new LinkedList<>();
			int[][] map = new int[101][101];
			boolean[] visited = new boolean[101];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int len = Integer.parseInt(st.nextToken()); 
			int start = Integer.parseInt(st.nextToken()); 
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<len/2; i++) {
				int from = Integer.parseInt(st.nextToken()); 
				int to = Integer.parseInt(st.nextToken());
				
				map[from][to] = 1;
			}
			
			int maxD = -1, maxV = -1;
			int[] first = {start, 0};
			q.offer(first);
			
			while (!q.isEmpty()) {
				int[] temp = q.poll();
				int v = temp[0], depth = temp[1];
				
				if (depth > maxD) {
					maxD = depth;
					maxV = v;
				} else if (depth == maxD) {
					maxV = v > maxV? v: maxV;
				}
				
				if (visited[v]) continue;
				
				visited[v] = true;
				for (int i=1; i<=100; i++) {
					if (map[v][i]==1 && !visited[i]) {
						int []next = {i, depth+1};
						q.offer(next);
					}
				}
			}
			
			System.out.println("#" + tc + " " + maxV);
		}
	}
}
