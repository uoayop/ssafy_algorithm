package com.ssafy.BOJ.Gold;

import java.util.Scanner;

public class BOJ_9663_NQueen {
	public static int n, cnt;
	public static int[] col;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		col = new int[n];		
		// 같은 행에는 놓지않는 것을 전제로 둠
		
		cnt = 0;	// 퀸을 놓는 방법의 수
		setQueen(0);	// 0행부터 놓겠다
		System.out.println(cnt);
	}

	private static void setQueen(int row) {
		if (row >= n) {
			cnt ++;
			return;
		}
		
		for (int i=0; i<n; i++) {
			col[row] = i;	// i열에 퀸 놓기
			if (isAvailable(row)) {
				setQueen(row+1);
			}
		}
	}

	private static boolean isAvailable(int row) {
		for (int q=0; q<row; q++) {
			// 같은 열에 두었거나, 대각선에 두었다면 return false
			if (col[row] == col[q] || Math.abs(col[row] - col[q]) == (row-q)) return false;
		}
		return true;
	}
}
