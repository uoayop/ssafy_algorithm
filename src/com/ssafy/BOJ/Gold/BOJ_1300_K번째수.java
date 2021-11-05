package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
# 이분탐색으로 어떤 수보다 작은 수의 곱(i*j)이 몇개인지 알아내면 됨
# a보다 작은 숫자가 몇개인지 찾아내면 a가 몇번째 숫자인지 알아낼 수 있음
'''
ex) n = 10, k = 20일 때 (== 배열크기가 10x10, 20번째 수)
10 * 10에서 20보다 작거나 같은 수의 개수는 (1*1 ~ 1*10), (2*1 ~ 2*10), (3*1 ~ 3*6) ... 
즉 (20 // 1) + (20 // 2) +  (20 // 3) + ...  + (20 // 10) 개 이다.
단, (20 // 1) 과 같이 n을 넘는 경우엔 n으로 할당해준다.
'''
*/

public class BOJ_1300_K번째수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int left = 0, right = k, answer = 0;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			
			for (int i=1; i<=n; i++) {
				cnt += Math.min((int)(mid/i), n);
			}
			if (cnt >= k) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			} 
		}
		System.out.println(answer);
	}
}
