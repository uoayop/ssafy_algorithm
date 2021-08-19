package com.ssafy.CantSolving;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5644_무선충전1 {
	public static int answer;					// 사용자 A와 B의 충전량 합
	public static int[]move_A, move_B;			// 사용자 A와 B가 이동하는 정보가 담긴 배열
	
	public static BC[][] map;					// map에 BC에 대한 정보 담기
	public static int[] dx = {0, -1, 0, 1, 0};	// 이동x, 상, 우, 하, 좌
	public static int[] dy = {0, 0, 1, 0, -1};

	
	public static class position{	// 사용자 위치 클래스
		int x;
		int y;
		
		public position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void setIndex(int dir) { 
			this.x = x + dx[dir]; 
			this.y = y + dy[dir]; 
		}

		@Override
		public String toString() {
			return "position [x=" + x + ", y=" + y + "]";
		}
	}
	
	public static class BC{		// BC 정보 클래스
		int c;
		int p;
		
		public BC(int c, int p) {
			this.c = c;
			this.p = p;
		}
		
		@Override
		public String toString() {
			return "BC [c=" + c + ", p=" + p + "]";
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());	// 이동 시간
		int a = Integer.parseInt(st.nextToken());	// BC의 수
		
		move_A = new int[m+1];
		move_B = new int[m+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=m; i++) {
			move_A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=m; i++) {
			move_B[i] = Integer.parseInt(st.nextToken());
		}
		
		map = new BC[10][10];
		for (int i=0; i<a; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			// BC의 좌표에서 c만큼 떨어진 곳에 BC 객체 저장
			DistanceCheck(x,y,c,p);
		}
		
		answer = 0;
		position A = new position(0,0);
		position B = new position(9,9);
		for (int i=0; i<=m; i++) {
			A.setIndex(move_A[i]);
			B.setIndex(move_B[i]);
			
			int Ax = A.x, Ay = A.y, Bx = B.x, By = B.y;
			
			BC Ac = map[Ax][Ay], Bc = map[Bx][By]; 
			boolean equals = Ac.equals(Bc);
			
			
			// BC 범위가 겹치는 지역에 위치하는 경우를 고려할 수 없음!
			if (Ac==null & Bc==null) continue;
			
			else if (Ac!=null & !equals) {
				answer += Ac.p;
			} 
			
			else if (Bc!=null & !equals) {
				answer += Bc.p;
			} 
			
			else if (equals) {
				answer += Ac.p;
			}
		}
		
		System.out.println(answer);
	}

	private static void DistanceCheck(int x, int y, int c, int p) {
		
		for (int i = x-c; i<= x+c; i++) {
			for (int j= y-c; j<= y+c; j++) {
				if (i<0 || i>=10 || j<0 || j>=10) continue;
				
				if (Math.abs(i-x) + Math.abs(j-y) <= c) {
					map[i][j]= new BC(c,p);
				}
			}
		}
	}
}
