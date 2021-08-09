package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218_4일차_괄호짝짓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t=1; t<=10; t++) {
			int length = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			Stack<Character> st = new Stack<>();
			
			
			boolean result = true;
			
			// 스택 비어있는지 체크하기!! 
			for (char c:arr) {
				if (st.isEmpty() || c=='(' || c=='{' || c=='[' || c=='<') {	// 스택이 비어있거나 여는 괄호이면
					st.push(c);
				}
				else if ((c==')' && st.peek()=='(') || 
					(c=='}' && st.peek()=='{') ||
					(c==']' && st.peek()=='[') ||
					(c=='>' && st.peek()=='<')) {
					st.pop();
				} 
				else {
					result = false;
					break;
				}
			} 
			
			if (st.isEmpty()) result = true;
			else result = false;
			
			System.out.printf("#%d %d\n",t, result? 1:0);
		}
	}
}
