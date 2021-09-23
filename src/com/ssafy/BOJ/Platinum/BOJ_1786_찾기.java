package com.ssafy.BOJ.Platinum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_1786_찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		
		// 부분 일치 테이블 만들기
		 int[] pi = makeSubTable(P);

		 int cnt = 0;	// cnt : T 중간에 P가 몇번 나타나는지 개수 세어줌
		 ArrayList<Integer> list = new ArrayList<>();
		 // list : P가 나타나는 위치를 저장
		 
		 for (int i=0, j=0; i<T.length; i++) {
			
			 // i: 텍스트 포인터, j: 패턴 포인터
			 while (j>0 && T[i]!=P[j]) j = pi[j-1];
			 // 같은 부분은 비교하지 않고, 다른 위치까지 점프
			 
			 if (T[i] == P[j]) {
				 // [텍스트와 패턴의 글자가 일치할 때] :
				 if (j == P.length-1) {	
					 // [패턴의 마지막 위치일때] :
					 // 텍스트에 패턴이 존재한다는 뜻
					 cnt++; 	
					 list.add(i-j+1);	// 패턴이 나타난 인덱스 저장
					 j = pi[j];			// 패턴 포인터 위치 옮기기
					 // 지금 패턴 포인터 j까지 패턴이 일치함
					 // pi[j] = 일치하는 길이의 다음 인덱스로 이동
				 } else {
					 // [패턴의 중간 위치일때] :
					 // 패턴 앞쪽 일치하면서 진행중이기 때문에 j를 다음 인덱스로 이동
					 j++;
				 }
			 }
		 }
		 
		 bw.write(cnt+"\n");
		 if (cnt > 0) {
			 for (int idx: list) {
				 bw.write(idx+"\n");
			 }
		 }
		 bw.flush();
	}

	// 부분 일치 테이블 만들기
	private static int[] makeSubTable(char[] p) {
		int[] pi = new int[p.length+1];
		
		// pi[i] : p의 i번째 인덱스까지 접두사와 접미사가 같은 최대 길이 
		// i:접미사 포인터, j:접두사 포인터
		for (int i=1, j=0; i<p.length; i++) {
			while (j>0 && p[i] != p[j]) {
				j = pi[j-1];
				// [접미사와 접두사가 같지 않을 때] : 
				// j의 위치를 직전 위치로 옮기면서 접미사와 접두사가 같아지는 위치를 찾거나
				// 맨 앞글자까지 이동
			}
			// [접미사와 접두사가 같을 때] : 
			// 유의미한 비교를 하기 위해서 다음 위치로 이동해 비교를 해야 함.
			// p[i] = 접두사 포인터  + 1
			if (p[i] == p[j]) pi[i] = ++j;
			else p[i] = 0;
		}
		return pi;
	}
}

/*
AAAABAABAAAAAAB
AAB
3
3
6
13
*/