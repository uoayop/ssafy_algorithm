package com.ssafy.CantSolving;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6026_성수의비밀번호공격 {
	public static long cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 사용되는 문자 종류  M, 비밀번호 자리수 N
		// 전사 함수
		// 전체 경우 : M ^ N
		
		// M-1 개의 숫자로 N 자리를 만들 수 있는 경우 : N C M-1
		// M-2 개의 숫자로 N 자리를 만들 수 있는 경우 : N C M-2
		// ...
		// 1개의 숫자로 N 자리를 만들 수 있는 경우 : N C 1
		
		int t = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			long result = pow(m,n);
			
			System.out.println(">> pow : "+result);
			System.out.println(m+" "+n);
			for (int i=1; i<m; i++) {
				cnt = 0;
				getSub(0, 0, m, i);	// n개 중에 m개 뽑기
				long pos = pow(n, i);
				long temp = (cnt * pos) % 1000000007;
				System.out.println(">> "+cnt+" "+pos+" "+temp);
				result -= temp;
			}
			
			System.out.println(result);
		}
	}

	private static void getSub(int index, int start, int n, int m) {
		if (index == m) {
			cnt++; 
			cnt %= 1000000007;
//			System.out.printf("n = %d, m = %d일 때 cnt는 %d\n", n, m, cnt);
		}
		
		for (int i=start; i<n; i++) {
			getSub(index + 1, i+1, n, m);
		}
	}

	private static long pow(int m, int n) {
		long ret = m;
		while (--n > 0) {
			ret = ret * m;
			ret %= 1000000007;
		}
		return ret;
	}
}
