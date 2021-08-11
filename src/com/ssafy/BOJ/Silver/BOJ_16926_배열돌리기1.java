package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1{
	public static int n, m, r;
	public static int[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int mid = Math.min(n, m) / 2;
//		for (int i=0; i<mid; i++) {
//			rotate(i,i, n - (2*(i+1)), m - (2*(i+1)));
//		}
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };	// 우 하 상 좌	
		// 오른쪽에 있는 애를 왼쪽으로 옮기기 때문에 ~~~
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<mid; j++) {
				int x = j; int y = j;
				
				int temp = arr[x][y];
				
				int dir = 0;
				while (dir < 4) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if (j <= nx && nx < n-j && j <= ny && ny < m-j) {
						arr[x][y] = arr[nx][ny];
						x = nx;
						y = ny;
					}else {
						dir++;
					}
				}
				arr[j+1][j] = temp;
			}
		}
		
		

		for (int []row: arr) {
			for (int col: row) {
				System.out.print(col+" ");
			}
			System.out.println();
		}
	}
}
//	private static void rotate(int start_x, int start_y, int r, int c) {
//		LinkedList<Integer> q = new LinkedList<>();
//		int[] dx = {1, 0, -1, 0};
//		int[] dy = {0, 1, 0, -1};	// 하 우 상 좌
//		int dir = 0;
//		
//		q.offer(arr[start_x][start_y]);
//		int x = start_x, y = start_y;
//		while (true) {
//			int nx = x + dx[dir];
//			int ny = y + dy[dir];
//			
//			if (dy[dir] == 0) {	// 가로로 이동
//				for (int i=0; i<c; i++) {
//					q.offer(arr[nx][ny]);
//					x = nx; y = ny;
//				}
//			} else {	// 세로로 이동
//				for (int i=0; i<r; i++) {
//					q.offer(arr[nx][ny]);
//					x = nx; y = ny;
//				}
//			}
//		
//			dir ++; dir %= 4; 
//			if (nx == start_x && ny == start_y) break;
//		}
//
//		
//		System.out.println(q);
//		for (int i=0; i<r; i++) {
//			q.offerFirst(q.pollLast());
//		}
//		
//		System.out.println(q);
//		
//		x = start_x; y = start_y;
//		arr[x][y] = q.poll();
//		while (true) {
//			int nx = x + dx[dir];
//			int ny = y + dy[dir];
//			
//			if (0 <= nx && nx < n && 0 <= ny && ny < m) {	// 범위 내에 있을 때
//				if (nx== start_x && ny == start_y) break;
//				arr[nx][ny] = q.poll();
//				x = nx; y = ny;
//
//			} else {
//				dir ++; dir %= 4; 
//			}
//		}
//		
//	}

