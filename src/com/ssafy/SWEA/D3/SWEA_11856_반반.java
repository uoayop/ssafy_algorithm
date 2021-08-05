// 반반

package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SWEA_11856_반반 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int t=1; t<=T; t++) {
			String str = br.readLine();
			HashMap<String, Integer> map = new HashMap<>();
			boolean result = false;
			for (int i=0; i<4; i++) {
				String curr = Character.toString(str.charAt(i));
				if (map.containsKey(curr)) {
					if (map.get(curr) >= 2) { result = true; break; }
					map.put(curr, map.get(curr) + 1);
				} else {
					map.put(curr, 1);
				}
			}
			
			for (Integer n: map.values()) {
				if (n != 2) { result = true; break; }
			}
			
			if (result) System.out.printf("#%d No\n", t);
			else System.out.printf("#%d Yes\n", t);
		}
	}
}
