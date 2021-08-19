package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3234_준환이의양팔저울 {
	public static int[] w;
	public static boolean[] visited;
	public static int n, mid, answer = 0, combiCnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		w = new int[n];
		
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i=0; i<n; i++) {
			w[i] = Integer.parseInt(st.nextToken());
			sum += w[i];
		}
		
		mid = sum / 2;	// 오른쪽이 mid 보다 크면 안됨
		visited = new boolean[n];
		
		makeSubset(0,0);
		
		System.out.println(answer);
	}

	private static void makeSubset(int index, int cnt) {
		// true인 요소 = 오른쪽 저울에 올라가는 애들
		// 만약 오른쪽 저울의 합이 mid보다 크면 return, 작거나 같으면 경우의 수 answer에 더하기
		
		if (index==n) {
			int temp = 0, leng = 0;
			for (int i=0; i<n; i++) {
				if (visited[i]) {temp += w[i]; leng ++;}
				if (temp > mid) return;
			}

			combiCnt = 0;
			combination(0, 0, leng);
			answer += combiCnt;

			System.out.println(Arrays.toString(visited)+"/ 오른쪽 저울 개수:"+leng +"/ combi(오른쪽):" + combiCnt);
			return;
		}
		
		visited[index] = true;
		makeSubset(index+1, cnt+1);
		visited[index] = false;
		makeSubset(index+1, cnt);
		
	}

	private static void combination(int index, int cnt, int leng) {
		if (index == leng) {
			combiCnt++;
		}
		
		for (int i=cnt; i<n; i++) {
			combination(index+1, i+1, leng);
		}
	}
}
