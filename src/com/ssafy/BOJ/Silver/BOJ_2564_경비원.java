package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2564_경비원 {
	public static class pos{
		int dir, dis;

		public pos(int dir, int dis) {
			this.dir = dir;
			this.dis = dis;
		}
	}
	
	public static pos[] stores;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		
//		boolean[][] map = new boolean[row][col];
		
		int cnt = Integer.parseInt(br.readLine());
		stores = new pos[cnt];
		
		for (int i=0; i<cnt; i++) {
			st = new StringTokenizer(br.readLine());
			stores[i] = new pos(
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		pos dong = new pos(
				Integer.parseInt(st.nextToken()), 
				Integer.parseInt(st.nextToken()));
		
		int answer = 0;
		for (int i=0; i<cnt; i++) {
			pos store = stores[i];
			if (store.dir == dong.dir) {
				answer += Math.abs(store.dis - dong.dis);
			} else {
				if (dong.dir == 1) {
					if (store.dir == 3) {
						answer += store.dis + dong.dis;
					} else if (store.dir == 2) {
						answer += Math.min(dong.dis + row + store.dis, 
								(col-dong.dis) + row + (col-store.dis));
					} else if (store.dir == 4) {
						answer += (col-dong.dis) + store.dis;
					}
				}
				
				else if (dong.dir == 3) {
					if (store.dir == 1) {
						answer += store.dis + dong.dis;
					} else if (store.dir == 2) {
						answer += (row-dong.dis) + store.dis;
					} else if (store.dir == 4) {
						answer += Math.min(dong.dis + col + store.dis, 
								(row-dong.dis) + col + (row-store.dis));
					}
				}
				
				else if (dong.dir == 2) {
					if (store.dir == 1) {
						answer += Math.min(dong.dis + row + store.dis, 
								(col-dong.dis) + row + (col-store.dis));
					} else if (store.dir == 3) {
						answer += (row-dong.dis) + store.dis;
					} else if (store.dir == 4) {
						answer += Math.min(dong.dis + col + store.dis, 
								(row-dong.dis) + col + (row-store.dis));
					}
				}
				
				else if (dong.dir == 4) {
					if (store.dir == 1) {
						answer += store.dis + (col-dong.dis);
					} else if (store.dir == 2) {
						answer += (row-dong.dis) + (col-store.dis);
					} else if (store.dir == 3) {
						answer += Math.min(dong.dis + col + store.dis, 
								(row-dong.dis) + col + (row-store.dis));
					}
				}
				
				System.out.println(answer);
			}
		}
	}
}
