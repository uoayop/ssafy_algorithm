package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	public static int[][] map;
	public static boolean[] alpha;
	public static int answer, r, c;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		
		for (int i=0; i<r; i++) {
			String row = br.readLine();
			for (int j=0; j<c; j++) {
				map[i][j] = row.charAt(j) - 65;	// A -> 0
			}
		}
		
		answer = 0;
		alpha = new boolean[26];
		
		dfs(0,0,0);
		System.out.println(answer);
	}
	
	private static void dfs(int x, int y, int cnt) {
		int curr = map[x][y];
		if (alpha[curr]) {
			answer = Math.max(answer, cnt);
			return;
		}
		else {
			alpha[curr] = true;
			for (int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if (0<=nx && nx < r && 0 <= ny && ny < c) {
					dfs(nx, ny, cnt+1);
				}
			}
			alpha[curr] = false;
		}
	}
}
