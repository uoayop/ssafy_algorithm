package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064_카잉달력 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			boolean find = false;
			int cnt = x;
			int max = getlcm(Math.max(m, n), Math.min(m, n));
			while (cnt <= max) {
				if (m==x && n==y) {
					cnt = max;
					find = true;
					break;
				}
				
				if (cnt % n == y) {
					find = true;
					break;
				} 
				
				if (cnt % n == 0) {
					if (n == y || cnt == y) {
					find = true;
					break;
					}
				}
				cnt += m;
			}
			if (find) System.out.println(cnt);
			else System.out.println(-1);
		}
	}

	private static int getlcm(int a, int b) {
		return a * b / getGCD(a, b);
	}

	private static int getGCD(int a, int b) {
		while (b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
	}
}

/*
8
8 2 4 2
10 12 2 12
12 10 12 10
12 10 1 1
12 6 12 6
10 1 5 1
1 10 1 5
1 1 1 1
*/