package com.ssafy.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {
	public static int n,m, answer;
	public static int[] selected, cards;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cards = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = 0;
		selected = new int[3];
		combination(0, 0);
		System.out.println(answer);
	}

	private static void combination(int index, int cnt) {
		if (index==3) {
//			System.out.println(Arrays.toString(selected));
			sumCheck(selected);
			return;
		}
		
		for (int i=cnt; i<n; i++) {
			if (cards[i] < m-1) { 
				selected[index] = cards[i];	// 카드가 m보다 클 때 고려해야 함
				combination(index+1, i+1);
			}
		}
	}

	private static void sumCheck(int[] selected) {
		int sum = 0;
		for (int n: selected) sum += n;
		if (sum <= m && answer < sum) answer = sum;
	}
}
