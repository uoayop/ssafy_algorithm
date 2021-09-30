package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {
	public static int n = -1;
	public static int[][] map, theif;
	public static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = 1;
		
		while (true){
			n = Integer.parseInt(br.readLine());
			if (n==0) break;
			
			map = new int[n][n];
			theif = new int[n][n];
			visited = new boolean[n][n];
			
			for (int i=0; i<n; i++) {
				Arrays.fill(theif[i], 999999);
			}
			
			for (int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dijkstra();
			bw.write("Problem "+t+": "+theif[n-1][n-1]+"\n");
			t++;
			bw.flush();
		} 
	}

	private static void dijkstra() {
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		theif[0][0] = map[0][0];
	
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0], y = curr[1];
//			visited[x][y] = true;
			visited[0][0] = true;
			
			for (int k=0; k<4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];
				
				if (nx < 0 || n <= nx || ny < 0 || n <= ny) continue;
				if (!visited[nx][ny]) {
					if (theif[nx][ny] > theif[x][y] + map[nx][ny]) {
						theif[nx][ny] = theif[x][y] + map[nx][ny];
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
}
