package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	public static class pos {
		int x, y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "pos [x=" + x + ", y=" + y + "]";
		}
	}
	
	public static Queue<pos> curr, next = null;
	public static int tomatoCnt = 0, days = 0, m, n;
	public static int[][] dir = {{1, 0},{-1, 0},{0, 1},{0, -1}}, box;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		curr = new LinkedList<>();
		box = new int[n][m];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				// 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 토마토가 들어있지 않은 칸
				if (box[i][j] >= 0) {
					tomatoCnt++;
					if (box[i][j] == 1) {
						curr.add(new pos(i,j));
					}
				}
			}
		}
		
//		System.out.println(curr);
		while (true) {
			curr = nextday();
			if (tomatoCnt == 0 || next.isEmpty()) break;
			days++;
//			printmap();
		} 
		
		if (tomatoCnt == 0 || zerocnt()) {
			bw.write(days+"\n");
		} else {
			bw.write("-1\n");
		}
		bw.flush();
	}

	private static boolean zerocnt() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (box[i][j] == 0) return false;
			}
		}
		return true;
	}

//	private static void printmap() {
//		for (int[] row: box) {
//			for (int col: row) {
//				System.out.printf("%2d ",col);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

	private static Queue<pos> nextday() {
		next = new LinkedList<>();
		while (!curr.isEmpty()) {
			pos tomato = curr.poll();
			int x = tomato.x, y = tomato.y;
			for (int d=0; d<4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if (0<=nx && nx<n && 0<=ny && ny<m) {
					if (box[nx][ny] == 0) {
						tomatoCnt--;
						box[nx][ny] = 1;
						next.add(new pos(nx,ny));
					}
				}
			}
		}
		
		return next;
	}
}
