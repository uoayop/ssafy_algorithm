// 새로운 불면증 치료법 

package com.ssafy.SWEA.D2;

import java.util.HashMap;
import java.util.Scanner;

public class SWEA_1288_새로운불면증치료법 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t=1;t<=T; t++) {
			int n = sc.nextInt();
			int cnt = 1;
			int num = 1;
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			
			String temp = "";
			while (cnt <= 10) {
				temp = Integer.toString(num * n);
				
				for (int i=0; i<temp.length(); i++) {
					if (!map.containsKey(temp.charAt(i))){
						map.put(temp.charAt(i), 1);
						cnt++;
					}
				}
				num ++;
			}
			
			System.out.printf("#%d %s\n",t,temp);
		}
	}
}
