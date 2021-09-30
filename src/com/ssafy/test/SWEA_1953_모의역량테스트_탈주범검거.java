package com.ssafy.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_모의역량테스트_탈주범검거 {
	public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};	// 상하좌우
	public static int[][] pipes = {{}, {0, 1, 2, 3}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {1, 2}, {0, 2}};
	public static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][m];
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[n][m];
			visited[r][c] = true;
			
			l -= 1; 	// 맨홀에 처음 있는 시간도 1로 침
			int cnt = 1;	// 경우의 수 + 1
			Queue<int []> q = new LinkedList<>();
			q.add(new int[] {r, c});
			
			while (l-- > 0) {	// l초 동안 이동
				int qLen = q.size();	// 큐에 담겨있는 좌표에 대해서만 체크할 것임!
				while (qLen-- > 0) {
					int[] curr = q.poll();
					int x = curr[0], y = curr[1];	// 현재 (x, y)
					visited[x][y] = true;
					
					int[] pipe = pipes[map[x][y]];	// 현재 좌표에 있는 터널
					for (int p: pipe) {
						int nx = x + dir[p][0];		// 다음 위치
						int ny = y + dir[p][1];		// 다음 위치
						
						if (nx < 0 || n <= nx | ny < 0 | m <= ny) continue;	// 범위 넘어가면 x
						if (map[nx][ny] == 0) continue; // 다음 위치에 터널이 없다면 이동 x
						if (visited[nx][ny]) continue; 	// 이미 방문한 곳이면 체크 x
						
						int[] nextPipe = pipes[map[nx][ny]];	// 다음 위치에 있는 터널
						if (CanGo(pipe, nextPipe, x, y, nx, ny)) {			// 현재 터널과 다음 터널이 연결된다면
							visited[nx][ny] = true;				// 다음 위치 방문 체크
							q.add(new int[] {nx, ny});			// 다음 위치를 큐에 추가해줌 : 현재 체크중인 턴이 끝나면 체크
							cnt ++;
						}
					}
				}
			}

//			System.out.println();	// 출력 확인
//			for (boolean[] row: visited) {
//				for (boolean col: row) {
//					if (col) System.out.print("1 ");
//					else System.out.print("0 ");
//				}
//				System.out.println();
//			}
			bw.write("#"+t+" "+cnt+"\n");
			bw.flush();
		}
	}

	private static boolean CanGo(int[] pipe, int[] nextPipe, int x, int y, int nx, int ny) {
		boolean[] curr = new boolean[4];
		boolean[] next = new boolean[4];
		
		for (int p: pipe) { curr[p] = true; }
		for (int p: nextPipe) { next[p] = true; }
		
		if (curr[0] && next[1] && (x > nx)) return true;
		if (curr[1] && next[0] && (x < nx)) return true;
		if (curr[2] && next[3] && (y > ny)) return true;
		if (curr[3] && next[2] && (y < ny)) return true;
		
		return false;
	}
}

/*
5
5 6 2 1 3
0 0 5 3 6 0
0 0 2 0 2 0
3 3 1 3 7 0
0 0 0 0 0 0
0 0 0 0 0 0
*/