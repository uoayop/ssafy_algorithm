package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2118_두개의탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] preSum = new int[n+1];
		preSum[1] = Integer.parseInt(br.readLine());
		
		for (int i=2; i<=n; i++) {
			preSum[i] = preSum[i-1] + Integer.parseInt(br.readLine());
		}
		
		int Dis = preSum[n];
		int ans = 0;
		
		for (int i=1; i<=n; i++) {
			int left = i, right = n;
			
			while (left <= right) {
				int mid = (left + right) / 2;
				int clock = preSum[mid] - preSum[i-1];
				int dclock = Dis - clock;
				
				if (clock < dclock)
					left = mid + 1;
				else 
					right = mid - 1;
				
				ans = Math.max(ans, Math.min(clock, dclock));
			}
		}
		
		bw.write(ans+"\n");
		bw.flush();
	}
}
