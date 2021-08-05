// 평범한 숫자

package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_11736_평범한숫자 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int cnt = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<n; i++) 
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=1; i < n-1; i++) {
				if (arr[i] > Math.max(arr[i-1], arr[i+1]) || arr[i] < Math.min(arr[i-1], arr[i+1])) {
					continue;
				}
				cnt++;
			}
			System.out.printf("#%d %d\n",t,cnt);
		}
	}
}
