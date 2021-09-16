package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {
	public static int k, w, h, answer = -1;
	public static int[][] map, monkey, horse;
	public static boolean[][][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		visited = new boolean[k+1][h][w];	// 0 ~ 30
		
		monkey = new int[][] {{-1, 0},{1, 0},{0, -1},{0, 1}};
		horse = new int[][] {{-1, -2},{-2, -1},{-2, 1},{-1, 2},{2, 1},{1, 2},{2, -1},{1, -2}};
		
		for (int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		int[] start = {0, 0, 0, 0};
		visited[0][0][0] = true;
		q.add(start);
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int jumpcnt = curr[0], movecnt = curr[1], x = curr[2], y = curr[3];
			
			if (x==h-1 && y==w-1) { answer = movecnt; break; }
			
			if (jumpcnt < k) {	// 말처럼 이동할 수 있을 때
				for (int i=0; i<8; i++) {
					int nx = x + horse[i][0];
					int ny = y + horse[i][1];
					
					if (0<=nx && nx<h && 0<=ny && ny<w) {
						if (!visited[jumpcnt+1][nx][ny] && map[nx][ny] == 0) {
							// 방문한 적이 없고, 장애물이 없는 위치일 때
							visited[jumpcnt+1][nx][ny] = true;
							int[] next = {jumpcnt+1, movecnt+1, nx, ny};
							q.add(next);
						}
					}
				}
			} 
		
			for (int i=0; i<4; i++) {
				int nx = x + monkey[i][0];
				int ny = y + monkey[i][1];
				
				if (0<=nx && nx<h && 0<=ny && ny<w) {
					if (!visited[jumpcnt][nx][ny] && map[nx][ny] == 0) {
						// 장애물이 없는 위치일 때
						visited[jumpcnt][nx][ny] = true;
						int[] next = {jumpcnt, movecnt+1, nx, ny};
						q.add(next);
					}
				}
			}
		}
		System.out.println(answer);
	}
}

/*
1
5 5
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 1 1
0 0 0 1 0
*/