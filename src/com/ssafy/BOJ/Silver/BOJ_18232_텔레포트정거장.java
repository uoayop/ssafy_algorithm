package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_18232_텔레포트정거장 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[n+1];
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (list[from] == null) {
				list[from] = new ArrayList<>();
			} 
			if (list[to] == null) {
				list[to] = new ArrayList<>();
			}
			list[from].add(to);
			list[to].add(from);
		}
		
		LinkedList<Integer> q = new LinkedList<>();
		q.add(s);
		
		boolean[] visited = new boolean[n+1];
		visited[s] = true;
		
		int time = 0;
		loop: while (!q.isEmpty()) {
			int size = q.size();
			
			while (size-- > 0) {
				int curr = q.poll();
				if (curr == e) break loop;
				
				if (list[curr] != null) {
					for (int next: list[curr]) {
						if (visited[next]) continue;
						visited[next] = true;
						q.add(next);
					}
				}
				if (curr-1 > 0 && !visited[curr-1]) {
					q.add(curr-1);
					visited[curr-1] = true;
				}
				if (curr + 1 <= n && !visited[curr+1]) {
					q.add(curr+1);
					visited[curr+1] = true;
				}
			}
			time++;
		}
		
		System.out.println(time);
	}
}
