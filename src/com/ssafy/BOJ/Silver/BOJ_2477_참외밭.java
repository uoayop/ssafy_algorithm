package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int[] vertex = new int[6];
		// row: 몇번째 점, col: (x,y)

		int mx = -1, my = -1;
		for (int i=0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			vertex[i] = Integer.parseInt(st.nextToken());
			
			if (i % 2 ==0) {
				mx = mx < vertex[i] ? vertex[i]: mx;
			} else {
				my = my < vertex[i] ? vertex[i]: my;
			}
		}

//		for (int[] row: vertex) {
//			for (int col: row) {
//				System.out.print(col +" ");
//			}
//			System.out.println();
//		}
//		System.out.println(mx+" "+ my);
		
		int tx = 0, ty = 0;
		for (int i = 0; i < 6; i++) {
//			System.out.println(vertex[(i + 5) % 6] +" "+ vertex[i] +" "+vertex[(i + 1) % 6]);
	        if (i % 2 == 0) {
	            if (my == (vertex[(i + 5) % 6] + vertex[(i + 1) % 6])) {
	                ty = vertex[i];
	            }
	        } else {
	        	if (mx == (vertex[(i + 5) % 6] + vertex[(i + 1) % 6])) {
	                tx = vertex[i];
	            }
	        }
	    }
		
//		System.out.println(tx+" "+ ty);
		int original = mx * my;
		int cut = tx * ty;
		System.out.println(k * (original-cut));
	}
}
