package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 가로 n / 세로 m
 * 열쇠 : a - f / 문 : A - F
 * 민식이 : 0 / 출구 : 1
 * 빈 곳 : . / 벽 : #
 * */

/*
 * 민식이 위치에서 4방향으로 좌표를 체크해주면서 Queue에 넣어줄건데
 * queue에 집어넣을때, a-f 까지 가지고 있는 열쇠 배열 + 방문 여부 확인하는 배열 넘기기
 * 
 * 만약 열쇠를 만난다면 방문 체크 배열 초기화, 민식이 초기위치에서 다시 탐색
 * 만약 문을 만난다면 열쇠를 갖고있는지 확인하고, 갖고있으면 방문
 * 만약 빈 곳이면 방문
 * 
 * 1 을 만난다면 거기서 출력 후 return
 * */


/*
 * 0. 같은 좌표를 방문하더라도 갖고있는 열쇠에 따라 결과가 다름! -> 3차원 배열로 고려 (x, y, key 리스트) 
 * 1. 현재 위치에서 4방향으로 한칸씩 늘리면서 탐색
 * 2. 이미 방문한 곳이면 X
 * 2-1. 열쇠를 만나면 열쇠 리스트에 추가 -> 방문 체크, cnt 1 증가시켜서 큐에 추가
 * 2-2. 문을 만나면 열쇠를 갖고있는지 확인 -> 방문할 수 있다면 방문 체크, cnt 1 증가시켜서 큐에 추가
 * 2-3. 빈 곳이라면 방문 체크, cnt 증가시켜서 큐에 추가
 * 
 * */

public class BOJ_1194_달이차오른다가자 {
	public static int n, m, sx, sy, ans = 0;
	public static char[][] map;
	public static boolean[][][] visited;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sx = 0;
		sy = 0;
		
		map = new char[n][m];
		
		for (int i=0; i<n; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j=0; j<m; j++) {
				map[i][j] = row[j];
				if (map[i][j] == '0') {
					sx = i; sy = j;
					map[i][j] = '.';
				}
			}
		}
		
		bfs();	// 이동할 수 있는 범위 모두 이동
		
		bw.write(ans+"\n");
		bw.flush();
	}
	
	public static class status {
		int x, y, cnt;
		HashMap<Character, Boolean> keyCheck;
		boolean[][] visited;
		
		public status(int x, int y, int cnt, HashMap<Character, Boolean> keyCheck, boolean[][] visited) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.keyCheck = keyCheck;
			this.visited = visited;
		}

		@Override
		public String toString() {
			return "status [x=" + x + ", y=" + y + ", cnt=" + cnt + ", keyCheck=" + keyCheck + ", visited="
					+ Arrays.deepToString(visited) + "]";
		}
	}
	
	private static void bfs() {
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		Queue<status> q = new LinkedList<>();
		boolean[][] start = new boolean[n][m];
		start[sx][sy] = true;
		q.add(new status(sx, sy, 0, new HashMap<>(), start));
		
		while (!q.isEmpty()) {
			System.out.println(q);
			System.out.println(Arrays.deepToString(map));
			
			status curr = q.poll();
			int cx = curr.x, cy = curr.y, cnt = curr.cnt;
			HashMap<Character, Boolean> keyCheck = curr.keyCheck;
			boolean[][] visited = curr.visited;
			
			if (map[cx][cy] == '1') {
				ans = cnt;
				return;
			}
			
			for (int k=0; k<4; k++) {
				int nx = cx + dir[k][0];
				int ny = cy + dir[k][1];

				
				if (nx < 0 || n <= nx || ny < 0 || m <= ny) continue;

//				System.out.println(">> "+map[nx][ny]+" -> "+(char)(map[nx][ny] + 32));
				
				if (map[nx][ny] == '#') continue;
				else if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
					if (keyCheck.containsKey(map[nx][ny]) && keyCheck.get(map[nx][ny])) { 
						q.add(new status(nx, ny, cnt+1, keyCheck, visited));
						continue; 
					}
					
					keyCheck.put(map[nx][ny], true);
					visited = new boolean[n][m];
					visited[sx][sy] = true;
					q.add(new status(sx, sy, cnt, keyCheck, visited));
					while (q.size() > 1) q.poll();
				}
				else if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
					if (visited[nx][ny]) continue;
					if (keyCheck.containsKey(((char)(map[nx][ny] + 32))) && keyCheck.get((char)(map[nx][ny] + 32))) {

						map[nx][ny] = '.';
						visited[nx][ny] = true;
						q.add(new status(nx, ny, cnt+1, keyCheck, visited));
					} else {
						continue;
					}
				} else {
					if (visited[nx][ny]) continue;
					
					visited[nx][ny] = true;
					q.add(new status(nx, ny, cnt+1, keyCheck, visited));
				}
			}
		}
	}
	
	
	

	
	
	
	
	/*
	private static void bfs() {
	
		// 열쇠 a를 갖고있는 상태에서 b를 얻게되면 => 3 = 000011(2) 
		System.out.println(1 | (1 << ('b' - 'a')));
		// ab를 갖고있는 상태에서 d를 얻게되면 => 11 = 0001011(2)
		System.out.println(3 | (1 << (int)('d' - 'a')));
		
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		visited = new boolean[n][m][64];	// 0 ~ 63
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sx, sy, 0, 000000});
		visited[sx][sy][0] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			System.out.println(Arrays.toString(curr));
			int cx = curr[0], cy = curr[1], cnt = curr[2], key = curr[3];
			
			if (map[cx][cy] == '1') {
				ans = cnt;
				return;
			}
		
			for (int k=0; k<4; k++) {
				int nx = cx + dir[k][0];
				int ny = cy + dir[k][1];
				
				if (nx < 0 || n <= nx || ny < 0 || m <= ny) continue;
				if (map[nx][ny] == '#') continue;
				
				else if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
					// 열쇠인 경우
					int newkey = key | (1 << (map[nx][ny] - 'a'));
					
					if (visited[nx][ny][newkey]) continue;

					visited[nx][ny][newkey] = true;
					q.add(new int[] {nx, ny, cnt+1, newkey});
				} else if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
					// 문인 경우 : 해당 문에 대한 키를 갖고있는지 확인해야함
					int keyCheck = key & (1 << (map[nx][ny] - 'A'));
					
					if (keyCheck == 0 || visited[nx][ny][key]) continue;

					visited[nx][ny][key] = true;
					q.add(new int[] {nx, ny, cnt+1, key});
				} else {
					if (visited[nx][ny][key]) continue;
				
					visited[nx][ny][key] = true;
					q.add(new int[] {nx, ny, cnt+1, key});
				}
			}
		}
		return;
	}
	*/
}
