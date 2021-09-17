package com.programmers.level1;

public class 신규아이디추천 {
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y  .abcdSDFefghijklm."));
		// "bat.y.abcdefghi"
	}
	
	public static String solution(String new_id) {
		String target = new_id.toLowerCase().trim();	// 소문자, 공백 제거
		
		String pattern = "[^a-z\\d\\-_.]*";	// 소문자, 숫자, -, _, . 만 허용
		target = target.replaceAll(pattern, "");
		
		pattern = "\\.{2,}";	// 마침표가 2개 이상이면
		target = target.replaceAll(pattern, ".");	// 한 개로 바꿈
		
		pattern = "^[.]|[.]$";	// 마침표로 시작하거나 끝나는지
		target = target.replaceAll(pattern, "");
		
		if (target == "") pattern = "a";
		if (target.length() > 15) target = target.substring(0, 15);
		
		System.out.println(target);
		String answer = "";
        return answer;
    }
}
