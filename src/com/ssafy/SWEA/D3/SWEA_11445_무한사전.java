package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_11445_무한사전 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T;t++) {
			String p = br.readLine();
			String q = br.readLine();
			boolean result = true;
			for (int i=0; i<p.length(); i++) {
				if (p.charAt(i)!=q.charAt(i)) {
					result = false; break;
				} 
			}
			if (!(p+"a").equals(q)) result = false;
			
			if (result) System.out.printf("#%d N\n",t);
			else System.out.printf("#%d Y\n",t);
		}
	}
}
