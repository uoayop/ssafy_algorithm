package com.ssafy.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3985_롤케이크 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int l = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int EMax = 0, EIndex = 0;	// 기대
		int RMax = 0, RIndex = 0;	// 실제
		
		int[] cakes = new int[l+1];
		int[] get = new int[n+1];
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			for (int x=start; x<=end; x++) {
				if (cakes[x]==0) {	// 누가 번호를 적지 않은 조각일 때만
					cakes[x] = i+1;	// 방청객 번호를 적음
					get[i+1] ++;
				}
			}

			int expect = end-start+1;
			if (expect > EMax) {EMax = expect; EIndex = i+1;}
			if (get[i+1] > RMax) {RMax = get[i+1]; RIndex = i+1;}
		}
		System.out.println(EIndex+"\n"+RIndex);
	}
}
