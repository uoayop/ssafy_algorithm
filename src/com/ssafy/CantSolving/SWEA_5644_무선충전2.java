package com.ssafy.CantSolving;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import com.ssafy.test.SWEA_5644_무선충전1.BC;

public class SWEA_5644_무선충전2 {
	public static int answer;					// 사용자 A와 B의 충전량 합
	public static int[]move_A, move_B;			// 사용자 A와 B가 이동하는 정보가 담긴 배열
	public static ArrayList<BC>[][] map;					// map에 BC에 대한 정보 담기
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
	}
	
	public static class BC implements Comparable<BC>{		// BC 정보 클래스
		int c;
		int p;
		
		public BC(int p, int c) {
			this.c = c;
			this.p = p;
		}

		@Override
		public int compareTo(BC o) {
			// power 오름차순 정렬
			return o.p-this.p;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=t; tc++) {
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
			
			
			// map에 BC에 대한 정보 담기
			map = new ArrayList[10][10];
			for (int i=0; i<10; i++) {
				for (int j=0; j<10; j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			
			for (int i=0; i<a; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				
				DistanceCheck(x,y,c,p);
			}
			
			answer = 0;
			position A = new position(0,0);
			position B = new position(9,9);
			
			for (int i=0; i<=m; i++) {
				A.setIndex(move_A[i]);
				B.setIndex(move_B[i]);
				
				int Ax = A.x, Ay = A.y;
				int Bx = B.x, By = B.y;
				
				// 사용자가 움직였을 때 그 좌표에 대한 배터리 정보값들 Ac, Bc
				ArrayList<BC> Ac = map[Ax][Ay], Bc = map[Bx][By]; 
				int Ap = Ac.isEmpty()? 0: Ac.get(0).p;
				int Bp = Bc.isEmpty()? 0: Bc.get(0).p;
				
				if (Ap==0 & Bp==0) continue;
				if (Ap == Bp) {//	가장 큰 파워가 같으면
					// 그 다음 파워를 꺼내서 비교하기
					int NAp = Ac.size() > 1? Ac.get(1).p : Ap;
					int NBp = Bc.size() > 1? Bc.get(1).p : Bp;
					
					if (NAp == NBp) {	
						answer += Ap;
					} else {
						answer += (NAp + NBp);
					}
				} else {
					answer += (Ap + Bp);
				}
			}
			
			System.out.println("#"+tc+" "+answer);
		}
		// 아직 못품 ㅠ
	}

	private static void DistanceCheck(int x, int y, int c, int p) {		
		for (int i = x-c; i<= x+c; i++) {
			for (int j= y-c; j<= y+c; j++) {
				if (i<0 || i>=10 || j<0 || j>=10) continue;
				
				if (Math.abs(i-x) + Math.abs(j-y) <= c) {
					map[i][j].add(new BC(p,c)); 
					Collections.sort(map[i][j]);
				}
			}
		}
	}
}
