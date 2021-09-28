package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 모든 점 ~ 원점까지의 거리가 짝수이거나 홀수여야만 원점으로 이동 가능함
 * */
public class SWEA_8458_원점으로집합 {
	public static ArrayList<Integer> list;	// list : 모든 점으로부터 원점까지의 거리를 저장할 리스트
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			list = new ArrayList<>();
			
			int max = -1;	// max : 가장 멀리 있는 점에서 원점까지 거리 저장  => 최댓값이 원점에 도달하는 순간 종료
			boolean isOdd = false;		// 거리가 홀수인지 체크
			boolean isEven = false;		// 거리가 짝수인지 체크
			long totalMove = 0;			
			int idx = 0;				
			
			int N = Integer.parseInt(br.readLine());
			while (N-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());	
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int sum = Math.abs(x) + Math.abs(y);
				list.add(sum);
				
				if (sum % 2 == 0) isEven = true;
				else isOdd = true;
				max = Math.max(sum, max);
			}
			
			if (max == 0)				// 모든 점이 이미 원점에 있는 경우
				bw.write("#"+t+" 0"+"\n");
			else if (isOdd && isEven)	// 거리가 홀수 + 짝수로 원점에 도달할 수 없는 경우
				bw.write("#"+t+" -1"+"\n");
			else {
				while (true) {
					totalMove += idx;
					if (checkPos(max, totalMove)) break;
					idx ++;
				}
				bw.write("#"+t+" "+idx+"\n");
			}
		}
		bw.flush();
	}
	
	private static boolean checkPos(int max, long totalMove) {
		if (totalMove < max) return false;
		
		for (int i=0; i<list.size(); i++) {
			if ((totalMove + list.get(i)) % 2 == 1)
				return false;
		}
		
		return true;
	}
}

/*
3
2
0 0
0 0
2
-6 0
3 3
2
-5 0
2 1
*/
