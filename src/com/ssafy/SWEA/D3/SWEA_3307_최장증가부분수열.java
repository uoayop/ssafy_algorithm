package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가부분수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] lis = new int[n];
			
			int max = 0;	// 전체중의 최대 길이
			for (int i=0; i<n; i++) {
				lis[i] = 1;
				for (int j=0; j<i; j++) {
					// j: i의 앞 쪽 원소
					if (nums[j] < nums[i] && lis[i] < lis[j] + 1) {
						lis[i] = lis[j] + 1;
					}
					// i를 끝으로 하는 최장 길이 값 계산 완료
				}
				if (max < lis[i]) max = lis[i];
			}
			System.out.println("#"+t+" "+max);
		}	
	}
}
