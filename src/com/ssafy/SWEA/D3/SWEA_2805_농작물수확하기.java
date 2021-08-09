package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* n = 5일 때, half = 2
 * 
                    a[0][2]
            a[1][1] a[1][2] a[1][3] 
            
    a[2][0] a[2][1] a[2][2] a[2][3] a[2][4] 
            a[3][1] a[3][2] a[3][3] 
                    a[4][2]
 */

public class SWEA_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());		// n = 5
			int[][] arr= new int[n][n];
			int answer = 0;
			
			for (int i=0; i<n; i++) {	// 입력 받기
				String row = br.readLine();
				for (int j=0; j<n; j++) {
					arr[i][j] = row.charAt(j) - '0';
				}
			}
			
			int half = n/2;									// half = 2
			
			for (int i=0; i<half; i++) { // 삼각형 위쪽			// i =  0    1
				for (int j=half-i; j<=half + i; j++) {		// j =  2	1~3
					answer += arr[i][j];
				}
			}
			
			for (int i=half; i>=0; i--) {	// 삼각형 아래쪽	    // i =   2   1   0
				for (int j=half-i; j<=half + i; j++) {		// j = 0~4  1~3  2
					answer += arr[n-i-1][j];
				}
			}
			
			System.out.printf("#%d %d\n",t, answer);
		}
	}
}


/*

재우님 코드 : 맨하탄 거리,,? 
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tt=1 ; tt<=t ; tt++) {
            int n = Integer.parseInt(br.readLine());
            int standard = n/2;
            int sum = 0;
            for(int i=0 ; i<n ; i++){
                String[] input = br.readLine().split("");
                for(int j=0 ; j<n ; j++) {
                    if(mht(standard,i,j)<=standard) sum +=Integer.parseInt(input[j]);
                }
            }
            System.out.printf("#%d %d\n", tt, sum);
        }
    }
    private static int mht(int standard, int i, int j) {        
        return Math.abs(standard-i)+Math.abs(standard-j);
    }    
}



 * */