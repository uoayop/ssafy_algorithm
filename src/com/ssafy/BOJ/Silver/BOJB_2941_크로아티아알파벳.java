package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJB_2941_크로아티아알파벳 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] croatia = {"c=", "c-", "dz=","d-", "lj", "nj","s=", "z="};
		char[] string = br.readLine().toCharArray();
		
		int cnt = 0;
		for (int i=0; i<string.length; i++) {
			if (i < string.length -1) {
				String temp = string[i] +""+ string[i+1];
				i += containString(croatia, temp);
			} 
			if (i <string.length - 2) {
				String temp = string[i] +""+ string[i+1] +"" + string[i+2];
				i += containString(croatia, temp);
			}
			cnt++; 
		}
		System.out.println(cnt);
	}

	private static int containString(String[] croatia, String temp) {
		for (String s: croatia) {
			if (s.equals(temp)) return temp.length()-1;
		}
		return 0;
	}
}
