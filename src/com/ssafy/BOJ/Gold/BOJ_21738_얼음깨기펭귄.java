package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_21738_얼음깨기펭귄 {
	public static ArrayList<Integer>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for (int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		/*for (int i=1; i<=N; i++) {
			System.out.println(i+" "+list[i]);
		}*/
		int cnt = 0;
		int ans = 1;

		boolean[] visited = new boolean[N+1];
		visited[P] = true;
		
		LinkedList<Integer> q = new LinkedList<>();
		q.add(P);
		
		int dis = 0;
		loop:
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int curr = q.poll();
				if (1 <= curr && curr <= S) { 
					ans += dis; 
					cnt ++; 
					System.out.println(curr+" "+dis);
				}
				if (cnt == 2) break loop;
				
				for (int next: list[curr]) {
					if (visited[next]) continue;
					visited[next] = true;
					q.add(next);
				}
			}
			dis++;
		}
		
		bw.write(N-ans+"\n");
		bw.flush();
	}
}
