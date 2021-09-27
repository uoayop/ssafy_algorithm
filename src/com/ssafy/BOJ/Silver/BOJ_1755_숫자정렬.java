package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1755_숫자정렬 {
	// 숫자를 문자열로 변환한 값과 실제 숫자를 저장할 클래스
	public static class Word implements Comparable<Word>{
		String word;	// 문자열로 변환된 숫자
		int num;		// 실제 숫자
		public Word(String word, int num) {
			// 클래스 생성자
			super();
			this.word = word;
			this.num = num;
		}
		@Override
		public int compareTo(Word o) {
			// 숫자들을 arrayList에 저장한 뒤, 문자열을 사전 순으로 정렬할 것이기 때문에
			// compareTo 재정의
			return word.compareTo(o.word);
		}
		
	}
	
	public static int m, n; // 숫자 범위 : m ~ n
	public static ArrayList<Word> list = new ArrayList<>(); // 변환된 문자열과 숫자가 들어가는 리스트
	public static String[] arr = {"zero", "one", "two","three","four","five","six","seven","eight","nine"};
	// 0부터 9까지 영어로 변환해줄 문자열 리스트 arr
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		for (int i=m; i<=n; i++) {
			char[] numTochar = Integer.toString(i).toCharArray();
			// 숫자를 (String -> char 배열)로 변환해 각 인덱스에 접근하기 쉽도록 해줌
			StringBuilder sb = new StringBuilder();
			// 숫자를 문자열로 변환한 뒤 저장해 줄 StringBuilder
			for (int j=0; j<numTochar.length; j++) {
				sb.append(arr[numTochar[j] - '0']); 
				// (char -> int) 변환을 위해 '0;을 빼줌
				if (numTochar.length > 1)
					sb.append(" ");
				// 만약 숫자 길이가 2 이상이라면 공백을 추가해 문자를 구분해줌
			}
			// 변환된 문자열, 실제 숫자 쌍을 리스트에 넣기
			list.add(new Word(sb.toString(), i));
		}
		// 변환된 숫자 문자열을 사전 순으로 정렬
		Collections.sort(list);
		for (int i=0; i<list.size(); i++) {
			System.out.print(list.get(i).num +" ");
			// 10개 단위로 출력한 뒤 줄바꿈
			if ((i+1) % 10 == 0) {
				System.out.println();
			}
		}
	}
}
