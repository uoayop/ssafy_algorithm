package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BOJ_10026_적록색약 {
	public static boolean[][] visited;
	public static char[][] map;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int n;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 구역의 개수를 셈
		int cnt = 0;
		visited = new boolean[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				// 처음 방문하는 곳일 때만 구역의 개수를 +1 해줌
				if (dfs(i,j)) cnt++;
			}
		}
		
		sb.append(cnt).append(" ");
		
		// 적색의 구역을 녹색으로 바꾸어줌
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (map[i][j]=='R') map[i][j]='G';
			}
		}
		
		// 한번 더 구역의 개수를 셈
		cnt = 0;
		visited = new boolean[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				// 처음 방문하는 곳일 때만 구역의 개수를 +1 해줌
				if (dfs(i,j)) cnt++;
			}
		}
		
		sb.append(cnt);
		
		System.out.println(sb.toString());
	}

	private static boolean dfs(int i, int j) {
		if (visited[i][j]) return false;
		// 방문한 곳이라면 이미 체크한 구역이므로 return false
		
		visited[i][j] = true;
		char curr = map[i][j];	// 현재 문자
		
		for (int k=0; k<4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if (0<=nx && nx < n && 0<=ny && ny < n) {
				char next = map[nx][ny];	// 상하좌우에 위치한 문자
				// 상하좌우 중 방문하지 않았고, 현재 문자와 같다면 dfs를 호출해 방문해줌
				if (!visited[nx][ny] && curr == next) {
					dfs(nx,ny);
				}
			}
		}
		return true;
	}
}
