package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1249_보급로 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 출발지 s, 도착지 g, 지도 크기 n x n
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			
			for (int i=0; i<n; i++) {
				char[] row = br.readLine().toCharArray();
				for (int j=0; j<n; j++) {
					map[i][j] = row[j]-'0';
				}
			}
			
			int ans = bfs(n, map);
			bw.write("#"+t+" "+ans+"\n");
			bw.flush();
		}
	}

	private static int bfs(int n, int[][] map) {
		int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
		boolean[][] visited = new boolean[n][n];
		
		int[][] path = new int[n][n];
		for (int i=0; i<n; i++) {
			Arrays.fill(path[i], 987654321);
		}
		path[0][0] = map[0][0];
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			int x = curr[0], y = curr[1];
			visited[0][0] = true;
			
			for (int k=0; k<4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];
				
				if (nx < 0 || n <=nx || ny < 0 || n<=ny) continue;
				if (visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				
				if (path[nx][ny] > path[x][y] + map[nx][ny]) {
					path[nx][ny] = path[x][y] + map[nx][ny];
					q.add(new int[] {nx, ny});
				}
				
				visited[nx][ny] = false;
			}
		}
		
		return path[n-1][n-1];
	}
}

/*
10
4
0100
1110
1011
1010

*/
