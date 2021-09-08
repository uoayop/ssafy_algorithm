package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1926_그림 {
	public static int count = 0, maxarea = 0, area, n, m;
	public static int[][] map;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (map[i][j]==1) {
					count++;
					area = 1;
					map[i][j] = 0;
					dfs(i,j);
					maxarea = Math.max(area, maxarea);
				}
			}
		}
		System.out.println(count);
		System.out.println(maxarea);
	}

	private static void dfs(int i, int j) {
		for (int k=0; k<4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (map[nx][ny] == 1) {
					map[nx][ny] = 0;
					area ++;
					dfs(nx, ny);
				}
			}
		}
	}
}
