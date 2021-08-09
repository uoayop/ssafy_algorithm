package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class SWEA_5432_쇠막대기자르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			char[] sticks = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			int answer = 0;
			
			for (int i=0; i<sticks.length; i++) {
				char curr = sticks[i];
				char prev = i>0? sticks[i-1] : '.';
				
				if (curr=='(' || stack.isEmpty())	// 열린 괄호이거나 스택이 비어있으면
					stack.add(curr);				// stack에 push
				else if (curr==')') {				// 닫힌 괄호이면 
					stack.pop();					// stack에서 pop
					if (prev == '(') { 	// 레이저를 만나면
						answer += stack.size(); 	// stack.size = 레이저로 잘린 막대기 개수를 더해줌
					} else {			//레이저가 아닌 닫힌 괄호일 경우
						answer ++;					// 기존의 잘린 막대의 개수를 더해줌
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, answer);
		}
	}
}

/*
2
()(((()())(())()))(())
(((()(()()))(())()))(()())
*/