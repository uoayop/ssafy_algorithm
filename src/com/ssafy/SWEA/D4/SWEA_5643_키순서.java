package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5643_키순서 {
	public static int[][] map;
	public static int INF = 999;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());	// 학생 n명
			int m = Integer.parseInt(br.readLine());
			
			map = new int[n+1][n+1];
			for (int i=0; i<=n; i++) {
				Arrays.fill(map[i], INF);
				map[i][i] = 0;
			}
			
			for (int i=0; i<m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
			}
			
			for (int k=1; k<=n; k++) {
				for (int i=1; i<=n; i++) {
					for (int j=1; j<=n; j++) {
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}
			
			int[] cnt = new int[n+1];
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					if (i!=j && map[i][j] != INF) { 
						cnt[i] ++;	// 노드 i에서 갈 수 있는 수
						cnt[j] ++;	// 노드 i로 갈 수 있는 노드 수
					}
				}
			}
			
			int res = 0;
			for (int i=1; i<=n; i++) {
				if (cnt[i] == n-1) res++;
			}
			
			bw.write("#"+t+" "+res+"\n");
			bw.flush();
		}
	}
}

/*
1
6
6
1 5  
3 4
5 4
4 2
4 6
5 2
*/