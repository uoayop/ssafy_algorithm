// 파리 퇴치

package com.ssafy.SWEA.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_2001_파리퇴치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					arr[i][j] =  Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			
			for (int i=0; i <= N-M; i++) {
				for (int j=0; j <= N-M; j++) {
					int sum = 0;
					for (int k=0; k<M; k++) {
						for (int l=0; l<M; l++) {
							int nx = i + l;
							int ny = j + k;
							
							sum += arr[nx][ny];
						}
					}
					answer = Math.max(sum, answer);
				}
			}
			bw.write("#"+t+" "+answer+"\n");
			bw.flush();
		}
	}
}

// 재우님은 dp 로 푸심 
// 관련 url : https://2jinishappy.tistory.com/139
