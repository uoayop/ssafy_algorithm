package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_13414_수강신청 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> chk = new HashMap<String, Integer>();
		Map<Integer, String> order = new HashMap<>();
		
		for (int i=1; i<=l; i++) {
			String ID = br.readLine();
			if (chk.containsKey(ID)) {	// 이미 입력된 학번이면
				order.remove(chk.get(ID));
			} 
			order.put(i, ID);
			chk.put(ID, i);
		}
		
		for (int i=1; i<=l; i++) {
			if (order.containsKey(i)) {
				k--;
				bw.write(order.get(i)+"\n");
			}
			if (k == 0) break;
		}
		bw.flush();
	}
}


