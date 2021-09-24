package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	public static class pos{
		int x, y;

		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "pos [x=" + x + ", y=" + y + "]";
		}
	}
	
	public static int R, C;
	
	public static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};	// 시계방향
	public static int[][] antidir = {{-1,0},{0,1},{1,0},{0,-1}}; // 반시계 방향
	
	public static int[][] map;
	public static ArrayList<pos> dusts;
	
	public static pos up, down; // up : 위쪽 공기청정기 위치, down : 아래쪽 공기청정기 위치
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];			// map : 격자판의 입력을 받기위한 리스트
		dusts = new ArrayList<>();		// dusts : 미세먼지 위치를 저장할 리스트
		
		for (int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == -1) {			// 공기 청정기 위치 저장
					if (up == null) {			// up : 위쪽 공기 청정기
						up = new pos(i,j);
					} else {
						down = new pos(i,j);	// down : 아래쪽 공기 청정기
					}
				} 
				else if (map[i][j] > 0) {		// 미세먼지 위치 저장
					dusts.add(new pos(i,j));
				}
			}
		}
		
		while (T-- > 0) {	
			spread();	// 미세먼지 확산
			getDust();
			
			clean(up, antidir, 0);	// 위쪽 공기 청정기 
			clean(down, dir, R-1);	/// 아래쪽 공기 청정기
			getDust();	
		}
		
		int answer = count();	// 남아있는 미세먼지 양 출력
		bw.write(answer+"\n");
		bw.flush();
	}

	private static void getDust() {
		// [미세먼지 위치 체크]
		dusts = new ArrayList<>();
		
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (map[i][j] > 0) {
					dusts.add(new pos(i,j));
				}
			}
		}
	}

	private static void spread() {   
		// [미세먼지 동시에 퍼짐]
		int[][] newmap = new int[R][C];
		for (int i=0; i<R; i++) {
			newmap[i] = Arrays.copyOf(map[i], map[i].length);
		}
		
		for (pos dust : dusts) {
			ArrayList<pos> isAvailable = new ArrayList<>();
			int cx = dust.x, cy = dust.y, currD = map[cx][cy];
			for (int d=0; d<4; d++) {
				int nx = cx + dir[d][0];
				int ny = cy + dir[d][1];
				
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if (currD < 5 || map[nx][ny] == -1) continue;	
				// 현재 위치 미세먼지 양이 5보다 적거나, 확산될 위치가 공기청정기가 있는 곳이면 확산이 일어나지 않음
				
				isAvailable.add(new pos(nx, ny));
				// 확산 가능한 경우 체크
			}
			
			for (pos newdust: isAvailable) {
				int dx = newdust.x;
				int dy = newdust.y;
				newmap[dx][dy] += currD / 5;	// 미세먼지가 주변으로 퍼짐
			}
			// 남은 미세먼지 양
			newmap[cx][cy] -= (currD / 5) * isAvailable.size();
		}
		// 기존 map에 적용
		map = newmap;
	}

	private static void clean(pos position, int[][] direction, int bx) {
		// [공기청정기 작동]
		// position : 위쪽, 아래쪽 공기 청정기
		// direction : 시계 방향, 반시계 방향
		// bx : x의 바운더리
		
		int di = 0;
		int cx = position.x, cy = position.y;
		int nx = cx + direction[di][0], ny = cy + direction[di][1];
		
		while (true) {
			if (map[cx][cy] == -1) map[nx][ny] = 0;
			else {
				map[cx][cy] = map[nx][ny];
			}
			
			// 경계에 도착하면 방향 바꿔줌
			if ((nx == bx && ny == 0) || (nx == bx && ny == C-1) || (nx == position.x && ny == C-1)) { di++; cx = nx; cy = ny; }
			else {
				cx += direction[di][0];
				cy += direction[di][1];
			}
			
			nx = cx + direction[di][0];
			ny = cy + direction[di][1];
			
			
			if (nx == position.x && ny == position.y) { map[nx][ny+1] = 0; break; }
		}
	}

	private static int count() {
		// [남은 미세먼지 양 체크]
		int cnt = 0;
		for (pos d: dusts) {
			cnt += map[d.x][d.y];
		}
		return cnt;
	}
	
	
	private static void printmap() {
		for (int[] row: map) {
			for (int col: row) {
				System.out.printf("%2d ",col);
			}
			System.out.println();
		}
		System.out.println();
	}
}
