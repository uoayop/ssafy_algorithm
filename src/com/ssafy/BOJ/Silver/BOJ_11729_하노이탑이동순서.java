// 하노이 탑 이동 순서

package com.ssafy.BOJ.Silver;

import java.io.*;

public class BOJ_11729_하노이탑이동순서 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void move(int n, int from, int mid, int to) throws IOException {
		// n = 출발지에 남아있는 원판의 갯수
		if (n==1) {
			bw.write(from+" "+to+"\n");
			return;
		}
		else {
			// 출발지에 가장 큰 원판이 한 개 남을 때까진 
			// 나머지 모든 요소들이 두번째 장대로 이동해야 함
			move(n-1, from, to, mid);
			
			bw.write(from+" "+to+"\n");
			
			move(n-1, mid, from, to);
		}
	}
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		
		bw.write(String.valueOf((int)Math.pow(2, n)-1)+"\n");
		// 첫번째 장대에서 세번째 장대로 옮김 (from:1, mid:2, to:3)
		move(n, 1, 2, 3);
		
		bw.flush();
	}
}
