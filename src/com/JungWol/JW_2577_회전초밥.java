package com.JungWol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class JW_2577_회전초밥 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/* 초밥의 종류를 번호로 표현
		 * 같은 초밥이 둘 이상 있을 수도 있음
		 * 
		 * 벨트의 특정 위치에서 k개의 접시를 연속해서 먹을 경우, 할인된 정액 가격
		 * 각 고객에게 쿠폰 발행 & k개 연속으로 먹으면 초밥 하나 무료로 제공
		 * 
		 * 손님이 먹을 수 있는 초밥 가짓수의 최대값을 구하기
		*/
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 접시의 수
		int d = Integer.parseInt(st.nextToken());	// 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken());	// 연속 접시 수
		int c = Integer.parseInt(st.nextToken());	// 쿠폰 번호
		
		int[] sushi = new int[n+k];
		int[] cnt = new int[d+1];
		for (int i=0; i<n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		System.arraycopy(sushi, 0, sushi, n, k-1);
		// k-1 개만큼 복사해서 붙여넣음
		
		int count = 0, max = 0;
		// count : 숫자 종류 카운트, max : 카운트들 중 최대
		for (int i=0; i<k; i++) {
			if (cnt[sushi[i]] == 0) { count ++; }
			cnt[sushi[i]]++;
		}
		
		for (int i=1; i<n; i++) {
			int bound = k-1;
			// k개의 접시 중 마지막에 추가하는 위치의 번호 카운트가 0이라면 
			// 기존에 없던 것이므로 +1
			if (cnt[sushi[i+bound]] == 0) {
				count ++;
			}
			cnt[sushi[i+bound]]++;
			
			// 한 칸 이동하면서 k개의 접시 중 빠지게 된 위치의 번호 카운트 처리
			cnt[sushi[i-1]] --;
			// k개의 접시 중 sushi[i-1] 접시에 적힌 숫자 카운트가 0이라면 
			// 해당 숫자가 더 이상 없다는 의미이므로 -1
			if (cnt[sushi[i-1]] < 1) {
				count --;
			}
			
			int bonus = count;
			if (cnt[c] == 0) {
				// 쿠폰에 적힌 초밥을 먹지 않았다면 
				// 보너스 초밥!
				bonus++;
			}
			
			if (bonus > max) {
				max = bonus;
			}
		}
		bw.write(max+"\n");
		bw.flush();
	}
}
