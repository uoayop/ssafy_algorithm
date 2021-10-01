package com.ssafy.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_4013_모의역량테스트_특이한자석 {
	public static LinkedList<Integer>[] magnets;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			int k = Integer.parseInt(br.readLine());
			magnets = new LinkedList[5];
			
			for (int i=1; i<=4; i++) {
				magnets[i] = new LinkedList<>();
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<8; j++) {
					magnets[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			
			
			while (k-- > 0) {
				st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				leftCheck(index-1, -dir);
				rightCheck(index+1, -dir);
				circulate(index, dir);
				
//				System.out.println(">> "+index+"번을 " + dir +" 방향으로 회전한 결과");
//				printQueue();
			}
			
			int answer = 0;
			for (int i=1; i<=4; i++) {
				answer += (magnets[i].get(0)) * Math.pow(2, i-1);
			}
//			System.out.println("----------------");
//			printQueue();
			
			bw.write("#"+t+" "+answer+"\n");
			bw.flush();
		}
		
	}
	
	private static void printQueue() {
		for (int i=1; i<=4; i++) {
			System.out.println(magnets[i]);
		}
	}

	private static void leftCheck(int idx, int dir) {
		if (idx == 0) return;
		// 왼쪽 체크

		LinkedList<Integer> left = magnets[idx];
		LinkedList<Integer> curr = magnets[idx+1];
		
//		System.out.printf("현재 %d번과 왼쪽 %d번을 비교하는 중 / %d번 왼쪽 = %d, %d번 오른쪽 = %d\n", idx, idx-1, idx, curr.get(6), idx-1, left.get(2));
		if (curr.get(6) != left.get(2))  { 
			leftCheck(idx-1, -dir);
			circulate(idx, dir);
		} 
	}

	private static void rightCheck(int idx, int dir) {
		if (idx == 5) return;
		// 오른쪽 체크

		LinkedList<Integer> right = magnets[idx];
		LinkedList<Integer> curr = magnets[idx-1];
//		System.out.printf("현재 %d번과 오른쪽 %d번을 비교하는 중 / %d번 오른쪽 = %d, %d번 왼쪽 = %d\n", idx, idx+1, idx, curr.get(2), idx+1, right.get(6));
		
		if (curr.get(2) != right.get(6))  { 
			rightCheck(idx+1, -dir);
			circulate(idx, dir);
		} 
	}

	private static void circulate(int index, int dir) {
		// index번 자석 curr을 dir 방향으로 회전
		
//		System.out.println(">> "+index+"번을 " + dir +" 방향으로 회전");
		LinkedList<Integer> curr = magnets[index];
		if (dir == 1) {	// 시계 방향
			int last = curr.pollLast();
			curr.addFirst(last);
		} else {
			int first = curr.pollFirst();
			curr.addLast(first);
		}
	}
}
