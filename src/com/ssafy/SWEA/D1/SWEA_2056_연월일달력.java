// 연월일 달력



package com.ssafy.SWEA.D1;

import java.util.Scanner;

public class SWEA_2056_연월일달력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int i=1 ; i<=T ; i++) {
			String date = sc.next();
			
			int year = Integer.parseInt(date.substring(0,4));
			int month = Integer.parseInt(date.substring(4,6));
			int day = Integer.parseInt(date.substring(6,8));
			
			Boolean answer = false;
			
			if (month < 1 || month > 12) {
				answer = true;
			} else if (month == 1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
				if (day < 1 || day > 31) {
					answer = true;
				}
			} else if (month==4 || month==6 || month==9 || month==11){
				if (day < 1 || day > 30) {
					answer = true;
				}
			} else {
				if (day < 1 || day > 28) {
					answer = true;
				}
			}
				
			if (answer) {
				System.out.printf("#%d -1",i);
			} else {
				System.out.printf("#%d %04d/%02d/%02d",i,year,month,day);
			}
			System.out.println();
		}
	}
}
