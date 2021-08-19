package com.ssafy.SWEA.D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_3일차_최적경로 {
	public static class position{	// 위치를 저장
		int x;
		int y;
		
		public position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// 집, 회사, 고객, 현재 위치 저장
	public static position home, company, customer, curr;
	public static position[] customers;	// customers[] : 입력 받은 고객의 위치를 배열로 저장
	public static int[] order;			// order[] : 고객 방문 순서를 순열로 만들어 저장
	public static boolean[] visited;	// visited[] : 순열을 위한 방문 체크 배열
	public static int n, answer;		// n : 고객의 수 / answer : 최단 경로의 이동거리
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			company = new position(
					Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

			home = new position(
					Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			
			customers = new position[n];
			for (int i=0; i<n; i++) {
				customers[i] = new position(
						Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			answer = Integer.MAX_VALUE;
			order = new int[n];
			visited = new boolean[n];
			permutation(0);	// 순열을 이용해 어떤 고객에게 먼저 방문할 지 정함 
			
			System.out.printf("#%d %d\n",t,answer);
		}
	}

	private static void permutation(int index) {
		if (index == n) {
			int distance = check(order);	
			// check 함수를 이용해 이동 거리 확인 
			answer = Math.min(answer, distance);
			// 더 작은 이동 거리를 answer 변수에 저장
			return;
		}
		
		for (int i=0; i<n; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			order[index] = i;
			permutation(index+1);
			visited[i] = false;
		}
	}

	private static int check(int[] order2) { 	// check() : 순열 배열에 따른 이동 거리 확인
		int temp = 0;
		
		for (int i=0; i<n; i++) {
			if (i==0) {
				temp += getDistance(company, customers[order[0]]);	// [회사 -> 첫번째 고객]
			} else if (i==n-1){
				temp += getDistance(customers[order[n-2]], customers[order[n-1]]);	// [n-1번째 고객 -> n번째 고객]
				temp += getDistance(home, customers[order[n-1]]);					// [n번째 고객 -> 집 ]
			}
			else {
				temp += getDistance(customers[order[i-1]], customers[order[i]]);	// [i-1번째 고객 -> i번째 고객]
			}
		}
		
		return temp;
	}
	
	private static int getDistance(position p1, position p2) { 	// getDistance() : 두 좌표 p1, p2 간 거리 계산
		return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
	}
}
