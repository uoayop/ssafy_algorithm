package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {
	public static class pos implements Comparable<pos>{
		int x, y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(pos o) {
			if (Math.abs(x)!= Math.abs(o.x))
				return Integer.compare(Math.abs(x), Math.abs(o.x));
			return Integer.compare(Math.abs(y), Math.abs(o.y));
		}

		@Override
		public String toString() {
			return "pos [x=" + x + ", y=" + y + "]";
		}
	}
	
	public static ArrayList<pos> store;
	public static int[][] dp;
	public static int INF = 2000000;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		while (T-->0) {
			boolean ans = false;
			int n = Integer.parseInt(br.readLine());	// 편의점 개수
			store = new ArrayList<>();
			dp = new int[n+2][n+2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			pos home = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				store.add(new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Collections.sort(store);
			st = new StringTokenizer(br.readLine());
			pos festival = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			store.add(0, home);
			store.add(n+1, festival);
			
			for (int i=0; i<n+2; i++) {
				for (int j=0; j<n+2; j++) {
					if (i==j) dp[i][j] = 0;
					else {
						int dis = getDistance(store.get(i), store.get(j));
						dp[i][j] =  (float)dis/50 > 20? INF : 1;
					}
				}
			}
			
//			for (int[] row: dp) {
//				for (int col: row) {
//					if (col==INF) System.out.print("INF ");
//					else System.out.print(col+" ");
//				}
//				System.out.println();
//			}
			
			if (dp[0][n+1]==INF) {
				out: for (int k=0; k<n+2; k++) {
					for (int i=0; i<n+2; i++) {
						for (int j=0; j<n+2; j++) {
							dp[i][j] =  Math.min(dp[i][j], dp[i][k] + dp[k][j]);
							if (i==0 && j==n+1 && dp[i][j]!=INF) {
								ans = true; break out;
							}
						}
					}
				}
			} else {
				ans = true;
			}
			
//			for (int[] row: dp) {
//				for (int col: row) {
//					if (col==INF) System.out.print("INF ");
//					else System.out.print(col+" ");
//				}
//				System.out.println();
//			}
			
			if (ans) {
				bw.write("happy\n");
			} else {
				bw.write("sad\n");
			}
		}
		bw.flush();
	}
	
	public static int getDistance(pos a, pos b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}


