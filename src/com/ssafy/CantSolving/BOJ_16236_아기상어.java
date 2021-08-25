package com.ssafy.CantSolving;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	public static class pos implements Comparable<pos>{
		int x, y, dist;

		public pos(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(pos o) {
			if (y==o.y) { 
				return x-o.x; 	// 가장 왼쪽에 있는 물고기
			}
			return y-o.y;
		}

		@Override
		public String toString() {
			return "pos [x=" + x + ", y=" + y + ", size=" + dist + "]";
		}
	}
	
	public static ArrayList<pos> list;
	public static int sec, curreat, n;
	public static int[][] map;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static pos shark;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= map[i][j] && map[i][j] <=6) {
				} else if (map[i][j] == 9) {
					shark = new pos(i,j,2);
					map[i][j] = 0;
				}
			}
		}

		Collections.sort(list);
		
		sec = 0; curreat=0;
		boolean caneat = true;
		while (caneat) {
			caneat = find(shark, sec);
		}
			
		System.out.println(sec);
	}

	private static boolean find(pos shark, int second) {
		list = new ArrayList<>();
		int cx = shark.x;
		int cy = shark.y;
		
		for (int k=0; k<4; k++) {
			int nx = cx + dx[k];
			int ny = cy + dy[k];
			
			if (nx<0 || nx >= n || ny<0 || ny>= n) continue;
			
			if (map[nx][ny] < shark.dist) {
				// 물고기 크기가 상어 크기보다 작으면 물고기를 저장
				list.add(new pos(nx,ny,map[nx][ny]));
			}
		}
		
		
		return false;
	}

//	private static boolean find(pos shark, int second) {
//		int next_i = -1;
//		int minDis = Integer.MAX_VALUE;
//		
//		int sharksize = shark.size;
//		for (int i=0; i<list.size(); i++) {
//			pos fish = list.get(i);
//			if (fish.size >= sharksize) {
//				continue;
//			}
//			
//			
//			
//			int fishDis = getDistance(shark.x, shark.y, fish.x, fish.y);
//			if (minDis > fishDis) {
//				minDis = fishDis;
//				next_i = i;
//			}
//		}
//		
//		if (next_i != -1) {
//			sec += minDis;
//			
//			pos fish = list.get(next_i);
//
//			System.out.printf("[shark] %d %d %d/ [fish] %d %d %d\n",shark.x, shark.y,shark.size, fish.x, fish.y,fish.size);
//			System.out.println("minDis="+minDis);
//			shark.x = fish.x;
//			shark.y = fish.y;
//			
//			if (curreat + 1 == shark.size) {
//				shark.size++;
//				curreat = 0;
//			} else {
//				curreat ++;
//			}
//
//			System.out.println("curreat="+curreat);
//			
//			list.remove(next_i);
//			for (pos p: list) {
//				System.out.println(p);
//			}
//			System.out.println(">");
//			return true;
//		}
//		
//		return false;
//	}
//
//	private static int getDistance(int x, int y, int x2, int y2) {
//		return (Math.abs(x-x2) + Math.abs(y-y2));
//	}
}

/*
map이 필요해
#input
3
9 2 2
2 2 3
1 3 1

#output
2
*/
