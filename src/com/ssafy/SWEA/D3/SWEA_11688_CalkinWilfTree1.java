package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_11688_CalkinWilfTree1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
	
		for (int t=1; t<=T; t++) {
			char[] str = br.readLine().toCharArray();
			int a = 1, b = 1;
			for (char order:str) {
				b = order == 'L'? a + b : b;
				a = order == 'R'? a + b : a;
			}
			System.out.printf("#%d %d %d\n",t,a,b);
		}
	}
}
