package com.ssafy.CantSolving;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	public static int[][] map, dir = {{-1,0},{1,0},{0,-1},{0,1}};
	public static boolean[][] isArea;
	public static int row, col;
	public static Queue<int[]> save;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		map = new int[row][col];
		
		for (int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isArea = new boolean[row][col];
		areaCheck();
	}

	private static void meltCheck() {
		save = new LinkedList<>();
		
		for (int i=0; i< row; i++) {
			for (int j=0; j<col; j++) {
				if (map[i][j] == 1) {	// 현재 칸이 치즈이고
					for (int k=0; k<4; i++) {
						int nx = i + dir[k][0];
						int ny = j + dir[k][1];
						if (0<=nx && nx<row && 0<=ny && ny<col) {
							if (isArea[nx][ny]) {	// 인접 칸이 공기이면
								isArea[i][j] = true;
								map[i][j] = 0;
							}
						}
					}
				}
			}
		}
		printmap(map);
	}

	private static void printmap(int[][] map2) {
		for (int[] row:map2) {
			for (int col: row) {
				System.out.print(col+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void areaCheck() {		
		int[] start = {0,0};
		
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0], y=curr[1];
			isArea[x][y] = true;
			
			for (int i=0; i<4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if (0<=nx && nx<row && 0<=ny && ny<col) {
					int[] next = {nx, ny};
					if (map[nx][ny] == 0 && !isArea[nx][ny]) {
						q.add(next);
						isArea[nx][ny] = true;
					}
				}
			}
		}
		meltCheck();
	}
}
