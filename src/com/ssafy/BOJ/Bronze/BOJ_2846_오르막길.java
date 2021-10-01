package com.ssafy.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2846_오르막길 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] nums = br.readLine().split(" ");
				
		int start = 0, end = 0, ans = 0;
		for (int i=n-1; i>0; i--) {
			int curr = Integer.parseInt(nums[i]);
			int next = Integer.parseInt(nums[i-1]);
			if (curr > next) {
				// 뒤에 있는 애가 더 크면
				end = Math.max(end, curr);
				if (i==1) {
					start = next;
					ans = Math.max(end - start, ans);
				}
			} else {
				start = curr;
				ans = Math.max(end - start, ans);
				end = 0; start = 0;
			}
		}

		System.out.println(ans);
	}
}
