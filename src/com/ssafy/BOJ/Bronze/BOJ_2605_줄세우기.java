package com.ssafy.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2605_줄세우기 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=1; i<=n; i++) {
			int order = Integer.parseInt(st.nextToken());
			int length = list.size();
			
			list.add(length-order, i);
		}
		
		for (int num:list) System.out.print(num+" ");
	}
}
