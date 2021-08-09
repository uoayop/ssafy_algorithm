package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와SpotMart {
	static int n, m, result;
	static int[] snacks;
	static int[] check;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			// n: 과자 봉지 개수, m: 무게 제한
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			result = -1;
			snacks = new int[n];
			check = new int[2];
			

			st = new StringTokenizer(br.readLine());
			for (int i=0; i<n; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0,0);
			System.out.printf("#%d %d\n",t,result);
		}
	}

	private static void permutation(int cnt, int start) {
		if (cnt == 2) {
			int ret = check[0] + check[1];
			if (ret <= m && result < ret)
				result = ret;
			return;
		}
		
		for (int i=start; i<n; i++) {
			check[cnt] = snacks[i];
			permutation(cnt+1, i+1);
		}
	}
}

/*
 * 
 
4
3 45
20 20 20
6 10
1 2 5 8 9 11
4 100
80 80 60 60
4 20
10 5 10 16
 
 
 
 * */
