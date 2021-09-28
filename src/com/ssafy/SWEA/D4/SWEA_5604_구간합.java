package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_5604_구간합 {
	public static int[] cnt;
	public static long A, B;
	public static String strA, strB;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			cnt = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//			long start = System.currentTimeMillis();
//			for (long i=A; i<=B; i++) {
//				sum += cal(i);
//			}
			cal();
			long sum = sum();
//			long end = System.currentTimeMillis();
			
			bw.write("#"+t+" "+sum+"\n");
//			bw.write("소요시간 : " + (end-start));
			bw.flush();
		}
	}
		
	private static long sum() {
		long sum = 0;
		for (int i=0; i<=9; i++) {
			sum += (i * cnt[i]);
		}
		return sum;
	}

//	// 시간 초과!
//	public static long cal(long i) {
//		long subSum = 0;
//		String str = Long.toString(i);	// String.valueOf(i); 와 동일
//		for (int idx=0; idx<str.length(); idx++) {
//			subSum += (str.charAt(idx) - '0');
//		}
//		return subSum;
//	}
	
	public static void cal() {
		// A의 끝자리는 0, B의 끝자리는 9
		int digit = 1;
		
		while (A <= B) {
			makeBtoNine(digit);
			if (B < A) break;
			
			makeAtoZero(digit);
			
			A /= 10;
			B /= 10;
			
			addSection(digit);
			
			digit *= 10;
		} 
	}

	private static void makeBtoNine(int digit) {
		while (B % 10 != 9 && A <= B) {
			strB = String.valueOf(B);
			addNum(strB, digit);
			B--;
		} 
	}

	private static void makeAtoZero(int digit) {
		while (A % 10 != 0 && A <= B) {
			strA = String.valueOf(A);
			addNum(strA, digit);
			A++;
		} 
	}

	private static void addSection(long digit) {
		for (int i=0; i<=9; i++) {
			cnt[i] += (B-A+1) * digit;
		}
	}

	private static void addNum(String str, long digit) {
		for (char c: str.toCharArray()) {
			cnt[c-'0'] += digit;
		}
	}
}
