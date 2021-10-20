package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		int[] nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		// n개의 숫자, 합이 m이 되는 경우의 수 구하기
		
		int ans = 0;
		if (n == 1) {	// 예외 처리
			if (nums[0] == m) bw.write("1\n");
			else bw.write("0\n");
		} else {
			int left = 0, right = 0;
			int sum = nums[left];
			
			while (true) {
				System.out.printf("left:%d, right:%d, sum:%d, ", left, right, sum);
				if (sum < m) { 
					if (right + 1 == n) { right = n-1; left++; }
					else sum += nums[++right];
				}
				else if (sum > m) { sum -= nums[left++];}
				else { ans++; sum -= nums[left++]; }
				
				System.out.printf("ans:%d\n",ans);
				if (left == n) break;
			}
			bw.write(ans+"\n");
		}
		bw.flush();
	}
}
