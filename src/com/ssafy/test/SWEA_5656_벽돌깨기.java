package com.ssafy.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/* --- 완전 탐색 (중복 순열)
 * 1. 구슬을 0열부터 w-1열까지 시도
 * 2. 구슬이 떨어졌을 때 처음 만나는 벽돌 찾기
 * 3. 함께 제거될 벽돌 탐색 (BFS, DFS)
 * 4. 부숴진 벽돌 정리 (벽돌 내리기)
 * 5. 다음 구슬 시도
 * */


public class SWEA_5656_벽돌깨기 {
	public static class Point{
		int r, c, cnt;	//행, 열, 벽돌 숫자

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static int n, w, h, min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[h][w];
			
			for (int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			go(0, map);
			bw.write("#" + t +" " + min+"\n");
			bw.flush();
		}
	}

	// go() : 중복 순열로 구슬을 던짐
	private static void go(int cnt, int[][] map) {
		// cnt : 구슬을 몇번 던졌는지
		if (cnt == n) {
			// cnt가 n번이 되면 모든 경우를 고려했다는 의미
			// 남아있는 벽돌 수 센 뒤, 최소값 갱신
			int result = count(map);
			min = Math.min(result, min);
			
			return;
		}
		
		int[][] newMap = new int[h][w];
		for (int col = 0; col < w; col++) {	// 0열부터 마지막열까지 시도
			// col열에 구슬이 던져졌을 때 가장 위에 있는 벽돌 찾아야함
			int row = 0;
			while (row < h && map[row][col]==0) row++;
			
			if (row == h) {
				// 구슬이 맵의 바닥까지 이동한 경우 == 벽돌이 없는 경우
				go(cnt+1, map);	// 다음 구슬 던지기
			} else { // 맞은 벽돌이 있는 경우
				// 이전 cnt까지의 map 상태를 복사해서 사용
				copy(map, newMap);
				
				// 맞은 벽돌과 주변 벽돌 함께 제거 처리 == 연쇄적 처리
				bombBFS(newMap, row, col);
//				 bombDFS(newMap, row, col, newMap[row][col]);
				
				// 제거된 벽돌들 내리기
//				down(newMap);
				 down2(newMap);
				
				// 다음 구슬 던지기
				go(cnt+1, newMap);
			}
		}
		
		
	}

	private static int count(int[][] map) {
		int cnt = 0;
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				if (map[i][j] > 0) cnt ++;
			}
		}
		return cnt;
	}
	
	private static ArrayList<Integer> list = new ArrayList<>();
	private static void down2(int[][] map) {
		for (int c=0; c<w; c++) {
			int r;
			for (r = h-1; r >= 0; r--) {
				if (map[r][c] > 0) {
					list.add(map[r][c]);
					map[r][c] = 0;	// 벽돌이 있던 자리는 빈칸으로
				} // 부서지지 않은 벽돌만 리스트에 담기
			}
			
			// 리스트에 있는 벽돌 제일 아리 행부터 채우기
			r = h;
			for (int b: list) map[--r][c] = b;
			list.clear();
		}
	}
	

	private static void down(int[][] map) {
		for (int c = 0; c < w; c++) {
			int r = h-1;
			while (r > 0) {
				if (map[r][c] == 0) {
					// 빈칸이면 벽돌 내리기
					int nr = r-1;	// 자신의 윗 행부터 탐색
					while (nr > 0 && map[nr][c] == 0) {
						// 0이 있는 동안 계속 위로 이동
						nr --;
					}
					
					// 내릴 녀석을 찾았거나 첫 행으로 이동함
					map[r][c] = map[nr][c];	// 현재 빈 칸에는 자신의 윗쪽으로 처음 만나는 벽돌로 내리기
					map[nr][c] = 0;	// 내린 벽돌 자리는 빈 칸으로 바꿔줌
				}
				
				--r;
				// 윗 행으로 이동
			}
		}
	}
	
	private static void bombDFS(int[][] map, int r, int c, int cnt) {
		// cnt : r,c 위치의 벽돌의 숫자
		// DFS로 함께  부숴질 벽돌 처리
		map[r][c] = 0;	// 현 위치의 벽돌 제거 처리
		if (cnt == 1) return; // 주변 벽돌을 터뜨릴 수 없음
		
		for (int d=0; d<4; d++) {
			int nr = r;
			int nc = c;
			
			for (int k=1; k < cnt; k++) {
				nr += dr[d];
				nc += dc[d];
				if (0 <= nr && nr < h && 0 <=nc && nc < w && map[nr][nc] > 0) {
					bombDFS(map, nr, nc, map[nr][nc]);
				}
			}
		}
		
	}

	private static void bombBFS(int[][] map, int r, int c) {
		// BFS로 함께  부숴질 벽돌 처리
		Queue<Point> q = new LinkedList<>();
		if (map[r][c] > 1) {	// 벽돌의 숫자가 1보다 클 때만 주변 벽돌 연쇄 처리
			q.add(new Point(r, c, map[r][c]));
			// bfs 처리 시 필요한 값이 큐에 들어감 --> dfs 처리 시 매개변수로 다 넣어주기!
		}
		map[r][c] = 0;
		// 벽돌 제거하고 빈칸 채우기
		
		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();
			for (int d=0; d<4; d++) {
				int nr = p.r;
				int nc = p.c;
				
				for (int k=1; k < p.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					if (0 <= nr && nr < h && 0 <=nc && nc < w && map[nr][nc] > 0) {
						if (map[nr][nc] > 1) {	// 벽돌의 숫자가 1보다 클 때만 주변 벽돌 연쇄 처리
							q.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
			}
		}
	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
}

//public class SWEA_5656_벽돌깨기 {
//	public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//	public static int n, w, h, map[][][];
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	
//		int T = Integer.parseInt(br.readLine());
//		while (T-- > 0) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			n = Integer.parseInt(st.nextToken());
//			w = Integer.parseInt(st.nextToken());
//			h = Integer.parseInt(st.nextToken());
//			
//			map = new int[n+1][w][h];
//			for (int i=0; i<w; i++) {
//				st = new StringTokenizer(br.readLine());
//				for (int j=0; j<h; j++) {
//					map[0][i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//			
//			// n개의 벽돌을 떨어뜨려 가장 많은 벽돌을 부시자
//			for (int cnt=0; cnt<n; cnt++) {
//				// 어떤 열에 떨어뜨려야 많은 벽돌을 부실 수 있는지 모르기 때문에 모두 체크 필요
//				for (int col=0; col<w; col++) {
//					// cnt번째 벽돌을 col열에 떨어뜨린다.
//					drop(cnt, col);
//				}
//			}
//		}
//	}
//
//	private static void drop(int cnt, int col) {
//		for (int i=0; i<h; i++) {
//			if (map[cnt][i][col] != 0) {
//				remove(cnt, i, col);
//			} 
//		}
//		
//		
//		
//	}
//
//	private static void remove(int cnt, int sx, int sy) {
//		Queue<int []> q = new LinkedList<>();
//		q.add(new int[] {sx,sy});
//		
//		int[][] copymap = new int[w][h];
//		for (int i=0; i<w; i++) {
//			copymap[i] = Arrays.copyOf(map[cnt][i], map[cnt][i].length);
//		}
//		
//		while (!q.isEmpty()) {
//			int[] temp = q.poll();
//			int x = temp[0], y = temp[1];
//			
//			if (copymap[x][y] == 0) continue;
//			else if (copymap[x][y] == 1) {
//				copymap[x][y] = 0;
//				continue;
//			}
//			
//			for (int c = 0; c < copymap[x][y]-1; c++) {
//				for (int k=0; k<4; k++) {
//					int dx = x + (dir[k][0] * c);
//					int dy = y + (dir[k][1] * c);
//					
//					if (dx < 0 || dx <= w || dy < 0 || dy <= h) continue;
//					if (map[cnt][dx][dy] == 0) continue;
//					q.add(new int[] {dx, dy});
//				}
//			}
//			
//			copymap[x][y] = 0;
//		}
//	}
//}
