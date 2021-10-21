package com.ssafy.CantSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 장기포게임 {
	public static class status{
		int x, y;
		int[][] map;
		public status(int x, int y, int[][] map) {
			this.x = x;
			this.y = y;
			this.map = map;
		}
		 
	}
	public static int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	public static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int sx = 0, sy = 0;
			int [][] map = new int[n][n];
			for (int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						// 포이면 위치 저장 후 장기 알 지우기
						sx = i; sy = j;
						map[i][j] = 0;
					}
				}
			}
			
			Queue<status> q = new LinkedList<>();
			q.add(new status(sx, sy, map));
			
			boolean[][] check = new boolean[n][n];
			
			int tryCnt = 3;
			while (tryCnt-- > 0 && !q.isEmpty()) {
				Queue<int[]> caught = new LinkedList<>();
				int len = q.size();
				while (len-- > 0) {
					status curr = q.poll();
					int cx = curr.x, cy = curr.y;
					int[][] currmap = curr.map;
					
					for (int k=0; k<4; k++) {
						boolean ismet = false;
						int nx = cx, ny = cy;
						while (true) {
							// 범위 내에 있는 동안 반복
							nx += dir[k][0];
							ny += dir[k][1];
							
							if (nx < 0 || n <= nx || ny < 0 || n <= ny) break;
							// 범위 넘어가면 멈추기
							if (currmap[nx][ny] == 1) {	// 장기말을 만남
								if (ismet) {	// 이전에 장기말을 만난 상태일 때니까 잡아먹음
									if (check[nx][ny])	// 이미 잡아먹은 말이면
										continue;
							
									currmap[nx][ny] = 0;
									q.add(new status(nx, ny, currmap));
									currmap[nx][ny] = 1;
									
									caught.add(new int[] {nx, ny});
									break;
								} else {
									// 장기말을 만났는데 이전에 만난 적이 없다면
									if (!check[nx][ny])	// 잡아먹은 말이 아닐때만
										ismet = true; // 이 이후의 범위만 큐에 넣음
								}
							} else {	// 길일 때
								if (ismet) {
									// 이전에 장기말을 만났다면 이동할 수 있는 칸이므로 큐에 넣음                    
									q.add(new status(nx, ny, currmap));
								}
							}
						}
					}
				}// 한 턴 끝났을 때
				for (int[] row: caught) {
					int x = row[0], y = row[1];
					if (!check[x][y]) {
						check[x][y] = true;
						cnt++;
					}
				}
				
				System.out.println(cnt);
			}
			
//			boolean[][] die = new boolean[n][n];
//			
//			int tryCnt = 1;
//			while (tryCnt++ <= 3 && !q.isEmpty()) {
//				Queue<int []> caught = new LinkedList<>();
//				int[][] copymap = new int[n][n];
//				for (int i=0; i<n; i++) {
//					copymap[i] = Arrays.copyOf(map[i], n);
//				}
//				
//				int len = q.size();
//				while (len-- > 0) {
//					int[] curr = q.poll();
//					int cx = curr[0], cy = curr[1];
//					
//					for (int k=0; k<4; k++) {
//						boolean ismet = false;
//						int nx = cx, ny = cy;
//						while (true) {
//							// 범위 내에 있는 동안 반복
//							nx += dir[k][0];
//							ny += dir[k][1];
//							
//							if (nx < 0 || n <= nx || ny < 0 || n <= ny) break;
//							// 범위 넘어가면 멈추기
//							if (copymap[nx][ny] == 1) {	// 장기말을 만남
//								if (ismet) {	// 이전에 장기말을 만난 상태일 때니까 잡아먹음
//									q.add(new int[] {nx, ny});
//								} else {
//									// 장기말을 만났는데 이전에 만난 적이 없다면
//									ismet = true; // 이 이후의 범위만 큐에 넣음
//								}
//							} else {	// 길일 때
//								if (ismet) {
//									// 이전에 장기말을 만났다면 이동할 수 있는 칸이므로 큐에 넣음
//									q.add(new int[] {nx, ny}); // 다음 칸으로 이동
//								}
//							}
//						}
//					}
//				}// 한 턴 끝났을 때
//				System.out.println(cnt);
//			}
//			
			System.out.println("#"+t+" "+cnt);
		}
	}
}



