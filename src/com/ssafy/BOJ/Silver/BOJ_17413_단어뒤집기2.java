package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_17413_단어뒤집기2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		char[] string = br.readLine().toCharArray();
		Queue<Character> q = new LinkedList<Character>();
		Stack<Character> stack = new Stack<>();
		boolean istag = false;
		
		for (char c: string) {
			if (c=='<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				
				istag = true;
				q.add(c);
			} else if (c=='>') {
				istag = false;
				q.add(c);
				while (!q.isEmpty()) {
					sb.append(q.poll());
				}
			} else if (c==' '){
				if (istag) {
					q.add(c);
				} else {
					while (!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(c);
				}
			} else {
				if (istag) q.add(c);
				else stack.add(c);
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
	}
}
