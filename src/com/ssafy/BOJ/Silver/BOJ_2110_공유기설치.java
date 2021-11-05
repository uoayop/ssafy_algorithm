package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 집 N개, 공유기 C개
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> houses = new ArrayList<>();
		for (int i=0; i<n; i++) {
			houses.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(houses);
		
		int left = 1, right = houses.get(n-1)-1, answer = 0;
		while (left<=right) {
			int mid = (left + right) / 2;
			System.out.printf("left: %d, mid: %d, right: %d ",left, mid, right);
			// 가장 인접한 공유기 사이 거리가 mid일 때, 설치해야 하는 공유기 개수 cnt
			
			int cnt = 1, curr = houses.get(0);
			for (int i=1; i<n; i++) {
				if (houses.get(i) - curr >= mid) {
					cnt++;
					curr = houses.get(i);
				} 
			}
			System.out.println(cnt+"개");
			if (cnt >= c) {
				left = mid + 1;
				answer = Math.max(mid, answer);
			} else {
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
