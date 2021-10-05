package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2343_기타레슨 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int left = 0, right = 0;
		
		int[] list = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			left = Math.max(list[i], left);
			right += list[i];
		}
		
		// 모든 강의를 m개의 비디오에 녹화할거임
		// 근데 모든 비디오의 크기는 M
		// M의 최소값을 구해야함
		
		while (left <= right) {
			int cnt = 0, temp = 0;
			// cnt : 비디오 개수
			// temp : 비디오 크기가 mid일 때 녹화한 강의 크기
			
			int mid = (left + right) / 2;
			
			for (int i=0; i<n; i++) {
				// 순차적으로 비디오를 담음 (list[i])
				// 만약 비디오를 담다가, 범위(mid) 를 벗어나면
				// 더 이상 담을 수 없으니까 
				// 비디오 개수를 1개 증가시켜서 다음 비디오에 담음
				// 다음 비디오로 넘어갔으므로 temp = 0
				if (temp + list[i] > mid) {
					cnt += 1;	// 비디오 개수 1개 증가
					temp = 0;
				}
				temp += list[i];
			}
			
			if (temp != 0) cnt += 1;
			// temp!=0 : 마지막 강의까지 녹화가 끝났는디 마지막 비디오 크기는 mid를 넘기지 못했을 때
			// 비디오 개수 1 증가
			
			// 비디오 개수가 m개보다 적을 때
			// 비디오 크기를 더 작게
			if (cnt <= m) {
				right = mid - 1;
			} else {
			// 비디오 개수가 m개보다 클 때
			// 비디오 크기를 더 크게
				left = mid + 1;
			}
		}
		
		System.out.println(left);
	}
}
