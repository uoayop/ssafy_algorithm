package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class SWEA_1223_6일차_계산기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t=1; t<=10; t++) {
			int len = Integer.parseInt(br.readLine());
			char[] str = br.readLine().toCharArray();
			Stack<Integer> stack = new Stack<>();
			boolean gop = false;
			int sum = 0;
			
			for (int i=0; i<len; i++) {
				if (i % 2 == 0) {	// 숫자이면
					stack.add(str[i]-'0');
					if (gop) {
						int temp = stack.pop() * stack.pop();
	                    stack.push(temp);
	                    gop = false;
					}
				} else {
					if (str[i]=='*') {
						gop = true;
					}
				}
			}
			
			while (!stack.isEmpty()) {
				sum += stack.pop();
			}
			
			System.out.println("#"+t+" "+sum);
		}
	}
}
