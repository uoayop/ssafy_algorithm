package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
	public static int n, MaxResult, MinResult;
	public static int[] oprList, nums;
	public static boolean[] visited;
	public static ArrayList<Integer> opr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		nums = new int[n];
		for (int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		opr = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			if (temp!=0) {
				for (int j=0; j<temp; j++) { opr.add(i); }
			}
		}
		
		MaxResult = Integer.MIN_VALUE;
		MinResult = Integer.MAX_VALUE;
		visited = new boolean[opr.size()];
		oprList = new int[opr.size()+1];
		permutation(0);
	}

	private static void permutation(int index) {
		if (index==opr.size()) {
			System.out.println(Arrays.toString(oprList));
			check(oprList);
			return;
		}
		
		for (int i=1; i<=opr.size(); i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			oprList[index] = opr.get(i);
			permutation(index+1);
			visited[i] = false;
		}
	}

	private static void check(int[] oprList) {
		int temp = nums[0];
		
		for (int i=1; i<=n; i++) {
			
		}
		
	}
}
