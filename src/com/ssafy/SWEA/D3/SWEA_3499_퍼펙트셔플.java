package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3499_퍼펙트셔플 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;
		 for(int t = 1; t<=T; t++){
			int n = Integer.parseInt(br.readLine());
			String[] str = new String[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<n; i++) {
				str[i] = st.nextToken();
			}
			
			
			sb = new StringBuilder();

			int mid = n % 2==0 ? n / 2: n/2+1;
			int left = 0;
			int right = mid;
			
			while (true) {
				sb.append(str[left++]+" ");
				sb.append(str[right++]+" ");
				
				if (left >= mid) break;
				if (right >= n) {
					if (left < mid) 
						sb.append(str[left]+" ");
					break;
				
				}
			}
			System.out.printf("#%d %s\n",t,sb.toString());
		}
	}
}
