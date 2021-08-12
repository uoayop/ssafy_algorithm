package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {
	
	// 음식의 신 맛과 쓴 맛을 저장하는 클래스 food
	public static class food{
		int sour;
		int bitter;
		
		public food(int sour, int bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}
	}
	
	public static food[] foods;				// 입력 받은 음식들을 저장할 배열
	public static boolean[] visited; 		// 부분 집합을 만들 때 방문 체크를 위한 배열
	public static int n;					// 음식의 개수
	public static int answer;				// 신 맛과 쓴 맛의 가장 작은 차이를 저장
	
	public static void main(String[] args) throws Exception {
		
		/* ------ 입력 받기 -------- */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		foods = new food[n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			foods[i] = new food(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));			
		}

		/* ------ 입력 받기 -------- */
		
		answer = Integer.MAX_VALUE; 
		
		visited = new boolean[n];
		subset(0, n);
		
		System.out.println(answer);
	}

	private static void subset(int index, int cnt) {	// subset : 부분 집합 만드는 함수 
		if (index == n) {
			Stack<food> stack = new Stack<>();
			for (int i=0; i<n; i++) {
				if (visited[i]) {
					stack.push(foods[i]);	// 선택된 음식이면 stack에 push
				}
			}
			answer = Math.min(answer, getTaste(stack));	// getTaste : 부분집합에 속한 음식의 맛을 구하는 함수
			return;
		}
		
		visited[index] = true;
		subset(index+1, cnt+1);
		visited[index] = false;
		subset(index+1, cnt);
	}

	private static int getTaste(Stack<food> stack) {
		// 공집합이면 첫번째 음식을 변수에 할당
		int bitter = stack.isEmpty()? foods[0].bitter: 0;
		int sour = stack.isEmpty()? foods[0].sour: 1;
		
		while (!stack.isEmpty()) {
			food f = stack.pop();	
			bitter += f.bitter;
			sour *= f.sour;
		}
		
		// 쓴 맛과 신 맛의 차이를 리턴
		return Math.abs(bitter-sour);
	}
}
