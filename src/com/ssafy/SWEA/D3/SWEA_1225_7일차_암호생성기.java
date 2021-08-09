package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_7일차_암호생성기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int t=1; t<=10; t++ ) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new LinkedList<>();
			
			while (st.hasMoreTokens()) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			int minus = 1;
			while (true) {
				if (q.peek() - minus <= 0) {
					q.poll(); q.offer(0); break;
				}
				
				q.offer(q.poll() - minus);
				
				minus = minus>=5 ? 1: minus+1;
			}
			
			bw.write("#" + t +" ");
			while(q.size()>0) {
				bw.write(q.poll()+" ");
			}
			bw.write("\n");
			bw.flush();
		}
	}
}
