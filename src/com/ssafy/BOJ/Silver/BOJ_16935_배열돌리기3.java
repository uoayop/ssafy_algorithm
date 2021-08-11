package com.ssafy.BOJ.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {
	public static int[][] arr;
	public static int n, m, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());	// 연산 수

		arr = new int[n][m];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<r; i++) {
			int order = Integer.parseInt(st.nextToken());
			Check(order);
		}
		
		for (int []row: arr) {
			for (int col:row) {
				System.out.print(col+" ");
			}
			System.out.println();
		}
	}
	
	public static void Check(int order) {
		switch(order) {
		case 1: updown(); break;
		case 2: leftright(); break;
		case 3: arr = right90(); break;
		case 4: arr = left90(); break;
		case 5: clockwise(); break;
		case 6: unclockwise(); break;
		}
	}

	private static void updown() {
		int mid = n / 2;	// 행 반으로 나누기
		for (int row = 0; row < mid; row++) {
			for (int col = 0; col < m; col++) {
				int temp = arr[row][col];
				arr[row][col] = arr[n-1-row][col];
				arr[n-1-row][col] = temp;
			}
		}
	}
	private static void leftright() {
		int mid = m / 2;	// 행 반으로 나누기
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < mid; col++) {
				int temp = arr[row][col];
				arr[row][col] = arr[row][m-1-col];
				arr[row][m-1-col] = temp;
			}
		}
	}

	private static int[][] right90() {
		int[][] newArr = new int[m][n];
		
		for (int row=0; row < m; row++) {
			int[] temp = new int[n];
			for (int col = 0; col < n; col++) {
				temp[col] = arr[n-1-col][row];
			}
			newArr[row] = temp;
		}

		int temp = n;
		n = m;
		m = temp;
		return newArr;
	}

	private static int[][] left90() {
		int[][] newArr = new int[m][n];
		
		for (int row=0; row < m; row++) {
			int[] temp = new int[n];
			for (int col = 0; col < n; col++) {
				temp[col] = arr[col][m-1-row];
			}
			newArr[row] = temp;
		}

		int temp = n;
		n = m;
		m = temp;
		return newArr;
	}
	
	
	private static void clockwise() {
		int halfw = m/2;
		int halfh = n/2;
		int[][] a = new int[halfh][halfw];
		int[][] b = new int[halfh][halfw];
		int[][] c = new int[halfh][halfw];
		int[][] d = new int[halfh][halfw];

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i<halfh && j<halfw)
					a[i][j] = arr[i][j];
				else if(i<halfh && j>=halfw)
					b[i][j-halfw] = arr[i][j];
				else if(i>=halfh && j<halfw)
					c[i-halfh][j] = arr[i][j];
				else
					d[i-halfh][j-halfw] = arr[i][j];
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i<halfh && j<halfw)
					arr[i][j] = c[i][j];
				else if(i<halfh && j>=halfw)
					arr[i][j] = a[i][j-halfw];
				else if(i>=halfh && j<halfw)
					arr[i][j] = d[i-halfh][j];
				else
					arr[i][j] = b[i-halfh][j-halfw];
			}
		}
	}

	private static void unclockwise() {
		int halfw = m/2;
		int halfh = n/2;
		int[][] a = new int[halfh][halfw];
		int[][] b = new int[halfh][halfw];
		int[][] c = new int[halfh][halfw];
		int[][] d = new int[halfh][halfw];

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i<halfh && j<halfw)
					a[i][j] = arr[i][j];
				else if(i<halfh && j>=halfw)
					b[i][j-halfw] = arr[i][j];
				else if(i>=halfh && j<halfw)
					c[i-halfh][j] = arr[i][j];
				else
					d[i-halfh][j-halfw] = arr[i][j];
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i<halfh && j<halfw)
					arr[i][j] = b[i][j];
				else if(i<halfh && j>=halfw)
					arr[i][j] = d[i][j-halfw];
				else if(i>=halfh && j<halfw)
					arr[i][j] = a[i-halfh][j];
				else
					arr[i][j] = c[i-halfh][j-halfw];
			}
		}
	}
}
