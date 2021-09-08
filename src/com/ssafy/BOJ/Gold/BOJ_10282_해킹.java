package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10282_해킹 {
	public static ArrayList<int []>[] list;
	public static int MAX_INT = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while (T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 컴퓨터 개수 n, 의존성 개수 d, 해킹당한 컴퓨터 번호 c
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[n+1];
			for (int i=1; i<=n; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				// 컴퓨터 a, 컴퓨터 b, s초 후 a도 감염됨
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int[] temp = {a, s};
				list[b].add(temp);
			}
		
			int[] visited = new int[n+1];
			Arrays.fill(visited, MAX_INT);
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(c);
			visited[c] = 0;
			
			while (!q.isEmpty()) {
				int curr = q.poll();
				
				for (int[] coms : list[curr]) {
					int next = coms[0];
					int time = coms[1];
					
					if (visited[next] > visited[curr] + time) {
						visited[next] = Math.min(visited[next], visited[curr] + time);
						q.add(next);
					}
				}
			}
			
			int cnt = 0, answer = 0;
			for (int v: visited) {
				if (v!=MAX_INT) {
					cnt++;
					answer = Math.max(answer, v);
				}
			}
			System.out.println(cnt+" "+answer);
		}
	}
}
