package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17390_이건꼭풀어야해 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 수열의 길이
		int q = Integer.parseInt(st.nextToken());	// 질문의 개수
		
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int[] sum = new int[n+1];
		sum[1] = arr[1];
		for (int i=1; i<=n; i++) {
			sum[i] = arr[i] + sum[i-1];
		}
		
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());	// 수열의 길이
			int r = Integer.parseInt(st.nextToken());	// 질문의 개수
			
			bw.write((sum[r] - sum[l-1]) +"\n");
		}
		bw.flush();
	}
}
