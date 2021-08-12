package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_3일차_최적경로 {
	public static class position{
		int x;
		int y;
		
		public position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static position home, company, customer, curr;
	public static position[] customers;
	public static int[] order;
	public static boolean[] visited;
	public static int n, answer;
	
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
			permutation(0);
			
			System.out.printf("#%d %d\n",t,answer);
		}
	}

	private static void permutation(int index) {
		if (index == n) {
			int distance = check(order);
			answer = Math.min(answer, distance);
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

	private static int check(int[] order2) {
		int temp = 0;
		
		for (int i=0; i<n; i++) {
			if (i==0) {
				temp += getDistance(company, customers[order[0]]);
			} else if (i==n-1){
				temp += getDistance(customers[order[n-2]], customers[order[n-1]]);
				temp += getDistance(home, customers[order[n-1]]);
			}
			else {
				temp += getDistance(customers[order[i-1]], customers[order[i]]);
			}
		}
		
		return temp;
	}
	
	private static int getDistance(position p1, position p2) {
		return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
	}
}
