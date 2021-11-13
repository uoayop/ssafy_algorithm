package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_3020_개똥벌레 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> floor = new ArrayList<>();
		ArrayList<Integer> ceil = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			// i가 짝수면 석순, 홀수면 종유석
			if (i % 2 == 0) floor.add(Integer.parseInt(br.readLine()));
			else ceil.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(floor);
		Collections.sort(ceil);
		
		int min = Integer.MAX_VALUE, minCnt = 0;
		for (int i=1; i<=h; i++) {	// 높이는 완전탐색
			int cnt = 0;
			System.out.println("------높이 "+i+"일 때");
			cnt += check(i-1, floor);
			cnt += check(h-i, ceil);
			
			System.out.println(">> "+cnt+"개");
			if (cnt < min) {
				min = cnt; minCnt = 1;
			} else if (cnt == min) {
				minCnt ++;
			}
		}
		System.out.println(min+" "+minCnt);
	}
	
	// 장애물의 개수는 이분탐색으로 h 보다 큰 요소의 개수를 찾으면 됨
	// right는 h보다 작은 값이 위치한 인덱스를 반환함
	private static int check(int h, ArrayList<Integer> list) {
		int left = 0, right = list.size()-1;
		while (left <= right) {
			int mid = (left + right) / 2; 
			
			if (list.get(mid) <= h) {
				left = mid + 1;
			} else if (list.get(mid) > h){
				right = mid - 1;
			} 
		}
		
		return (list.size()-(right + 1));
	}
}
