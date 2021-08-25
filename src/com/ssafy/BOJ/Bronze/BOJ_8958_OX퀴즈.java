package com.ssafy.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_8958_OX퀴즈 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			char[] string = br.readLine().toCharArray();
			
			int score = 0, win = 1;
			for (int i=0; i<string.length; i++) {
				if (string[i] == 'O') {
					score += win;
					win++;
				} else win = 1;
			}
			System.out.println(score);
		}
	}
}
