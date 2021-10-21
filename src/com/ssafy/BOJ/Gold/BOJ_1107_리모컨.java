package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


// https://www.acmicpc.net/board/view/46120
public class BOJ_1107_리모컨 {
	public static int want, nearestNum = 1000000000, minDis = 1000000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		want = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int len = (want+"").toCharArray().length;
		
		boolean[] can = new boolean[10];
		Arrays.fill(can, true);
		
		if (m!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<m; i++) {
				int idx = Integer.parseInt(st.nextToken());
				can[idx] = false;
			}	// 안눌리는 숫자 키 false
		}
		
		int justStep = Math.abs(100 - want);
		if (want == 100) bw.write("0\n");
		else {
			makePermutation(0, len-1, can, new int[len-1]); 
			makePermutation(0, len, can, new int[len]);
			makePermutation(0, len+1, can, new int[len+1]); 
			
			int newNumlen = (nearestNum+"").length();
			
			System.out.println(nearestNum+" "+newNumlen+" "+justStep);
			if (newNumlen + minDis < justStep) 
				bw.write((newNumlen + minDis) + "\n");
			else 
				bw.write(justStep+"\n");
		}
		bw.flush();
	}
	
	private static void makePermutation(int cnt, int len, boolean[] can, int[] select) {
		if (len < 1) return; 
		
		if (cnt == len) {
			StringBuilder sb = new StringBuilder();
			for (int n: select) sb.append(n);
			
			int num = Integer.parseInt(sb.toString());
			int dis = getDis(num);
			
			if (minDis > dis) {
				minDis = dis;
				nearestNum = num;
			}
			return;
		}
		
		for (int i=0; i<10; i++) {
			if (!can[i]) continue;
			select[cnt] = i;
			makePermutation(cnt+1, len, can, select);
		}
	}

	private static int getDis(int n) {
		return Math.abs(n - want);
	}
}
