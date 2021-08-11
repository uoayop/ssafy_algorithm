package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i=1; i<=n; i++) {
			q.offer(i);			// 큐에 1부터 n까지 숫자 넣기
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while (!q.isEmpty()) {
			for (int i=0; i<k-1; i++) {	// k-1번  left shift
				q.offer(q.poll());
			}
			
			// k번째 원소 빼서 stringbuilder에 추가하기
			String inputs = q.size()==1? q.poll() + ">" : q.poll() + ", ";
			sb.append(inputs);
		}	
		System.out.println(sb.toString());
	}
}
