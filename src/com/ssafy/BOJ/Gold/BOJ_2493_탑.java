package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		Stack<int []> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) {
			int height = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= height) {
					System.out.print(stack.peek()[0] +" ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				System.out.printf("0 ");
			}
			stack.push(new int[] {i, height});
		}
	}
}



//public class BOJ_2493_탑 {
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	static StringBuilder sb = new StringBuilder(" ");
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		int n = Integer.parseInt(br.readLine());
//		int[] tops = new int[n];
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for (int i=0; i<n; i++) {
//			tops[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		int l, r;
//		
//		for (int i = n-1; i > 0; i--) {
//			r = i;
//			l = i-1;
//			while (true) {
//				if (0 > l) {
//					sb.insert(0, " " + 0);
//					break;
//				} if (tops[l] >= tops[r]) {
//					sb.insert(0, " " + (l+1));
//					break;
//				}
//				l--;
//			}
//			
//			
//		}
//		sb.insert(0, "0");
//		
//		bw.write(sb.toString());
//		bw.flush();
//	}
//}
