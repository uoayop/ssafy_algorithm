package com.ssafy.BOJ.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {
	public static int[][] arr;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		StringTokenizer st = null;
		
		arr = new int[9][9];
		for (int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Stack<int []> stack = new Stack<>();
		
		int i = 0, j = 0, k = 1;
		while (i<9 && j<9) {
			int preX = i, preY = j;
			if (arr[i][j] == 0) {
				for (int t = k; t<=9; t++) {	// 1 ~ 9 체크
					if (Check(new int[] {i, j, t})) {
						arr[i][j] = t;
						stack.add(new int[] {i, j, t});
						
						j++;
						if (j == 9) {
							i++; j = 0;
						}
						
						k = 1;
						break;
					}
				}
				
				if (arr[preX][preY] == 0) {
					int[] temp = stack.pop();
					int tempX = temp[0], tempY = temp[1], tempV = temp[2];
					arr[tempX][tempY] = 0;
					i = tempX;
					j = tempY;
					k = tempV + 1;
				}
			} 
			
			if (preY != j) continue;
			j++;
			if (j==9) {i++; j=0;}
		}
		printMap();
	}
	
	// 채울 수 있으면 true 반환
	private static Boolean Check(int [] p) throws IOException {
		int x = p[0], y = p[1], v = p[2];
		
		for (int col=0; col<9; col++) {
			if (arr[x][col] == v) return false;
		}
		
		// 같은 열(y)에 v가 있는지 확인
		for (int row=0; row<9; row++) {
			if (arr[row][y] == v) return false;
		}
		
		// 사각형에 v가 있는지 확인
		int squareX = x / 3, squareY = y / 3;
		for (int i=(3 * squareX); i<(3 * squareX) + 3; i++) {
			for (int j=(3 * squareY); j<(3 * squareY) + 3; j++) {
				if (arr[i][j] == v) return false;
			}
		}
		
		return true;
	}
	
	public static void printMap() throws IOException {
		StringBuilder sb = null;
		for (int i=0; i<9; i++) {
			sb = new StringBuilder();
			for (int j=0; j<9; j++) {
				sb.append(arr[i][j]).append(" ");
			}

			bw.write(sb.toString()+"\n");
		}
		bw.flush();
	}
}