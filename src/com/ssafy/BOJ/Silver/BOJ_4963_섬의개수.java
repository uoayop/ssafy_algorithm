package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	public static class pos{
		int x, y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static ArrayList<pos> list;
	public static int w, h, map[][], dir[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
	// 상하좌우대각선
	public static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		
			if (w==0 && h==0) break;
			
			list = new ArrayList<>();
			visited = new boolean[h][w];
			
			map = new int[h][w];
			for (int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) { list.add(new pos(i,j)); }	// 섬이면 list에 추가
				}
			}
			
			int cnt = 0;
			for (pos p: list) {
				if (!visited[p.x][p.y]) {	// 방문하지 않은 곳일때만 연결된 섬 체크
					visited[p.x][p.y] = true;
					dfs(p.x, p.y);			// 섬의 개수 + 1
					cnt++;
				}
			}
			bw.write(cnt+"\n");
			bw.flush();
		}
	}
	
	private static void dfs(int x, int y) {
		// 연결된 모든 곳 방문 체크
		for (int k=0; k<8; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];
			
			if (nx < 0 || h <= nx || ny < 0 || w <= ny) continue;
			if (map[nx][ny] == 1 && !visited[nx][ny]) { 
				visited[nx][ny] = true; 
				dfs(nx, ny); 
			}
		}
	}
}
