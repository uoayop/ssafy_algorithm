package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1206_1일차_View {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t=1; t<=10; t++) {
			int height = Integer.parseInt(br.readLine());
			int[] building = new int[height];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<height; i++) {
				building[i] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			
			for (int i=2; i<height-2; i++) {
				int max_height = (max(building[i-2], building[i-1], building[i+1], building[i+2]));
//				System.out.printf("max: %d / curr: %d\n", max_height, building[i]);
				if (max_height >= building[i]) continue;
				else answer += building[i] - max_height;
			}
			System.out.printf("#%d %d\n",t, answer);
		}
		
	}

	private static int max(int i, int j, int k, int l) {
		return Math.max(Math.max(i, j), Math.max(k, l));
	}
	
}
