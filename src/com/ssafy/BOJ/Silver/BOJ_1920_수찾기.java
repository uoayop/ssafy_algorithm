package com.ssafy.BOJ.Silver;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class BOJ_1920_수찾기 {
	public static int n, m, nums[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++) {
			int target = Integer.parseInt(st.nextToken());
			bw.write(find(target)+"\n");
		}
		bw.flush();
	}

	private static int find(int target) {
		int left = 0, right = n-1;
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (nums[mid] == target) return 1;
			else if (nums[mid] > target) 
				right = mid - 1;
			else 
				left = mid + 1;
		}
		return 0;
	}
}
