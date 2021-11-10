package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		/* 이분 탐색 */
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		System.out.println(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			int lower = lower(arr, num);
			int upper = upper(arr, num);
			
			System.out.println(num+" "+lower+" "+upper);
			if (upper == -1) sb.append("0 ");
			else sb.append(upper - lower + 1).append(" ");
		}
		bw.write(sb.toString()+"\n");
		bw.flush();
		/* -------해시
		 * // 카드 N개, 정수 M개
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> check = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (check.containsKey(num)) {
				check.put(num, check.get(num)+1);
			} else {
				check.put(num, 1);
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (check.containsKey(num)){
				sb.append(check.get(num)).append(" ");
			} else {
				sb.append("0 ");
			}
		}
		bw.write(sb.toString()+"\n");
		bw.flush();*/
	}

	private static int upper(ArrayList<Integer> arr, int num) {
		int left = 0, right = arr.size()-1, mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (arr.get(mid) <= num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		if (arr.get(right) == num) return right;
		else return -1;
	}

	private static int lower(ArrayList<Integer> arr, int num) {
		int left = 0, right = arr.size()-1, mid = 0;
		
		while (left <= right) {
			mid = (left + right) / 2;
			if (arr.get(mid) < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		if (arr.get(left) == num) return left;
		else return -1;
	}
}
