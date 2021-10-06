package com.ssafy.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설 {
	static int  N,X,map[][];
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = null;
		for(int t=1; t<=TC; ++t) {
			st = new StringTokenizer(in.readLine().trim());
			N = Integer.parseInt(st.nextToken()); //절벽지대 크기 
			X = Integer.parseInt(st.nextToken()); //경사로길이 
			map = new int[N][N];
			for(int i=0; i<N; ++i) {
				st = new StringTokenizer(in.readLine().trim());
				for(int j=0; j<N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+t+" "+process());
		}
	}
	private static int process() {
		int count = 0;
		for(int i=0; i<N; ++i) {
			if (makeRoadByRow(i)) count++;
			if (makeRoadByCol(i)) count++;
		}
		return count;
	}

	private static boolean makeRoadByRow(int i) {//가로활주로 가능 여부
		int beforeHeight= map[i][0],size=1;
		int j = 1;
		while(j<N) {// 두번째 칸부터 처리
			if(beforeHeight==map[i][j]) { // 이전과 높이가 같으면 연속길이 증가
				size++;
				++j;
			}else if(map[i][j]  == beforeHeight+1 ) { // 이전보다 높이가 1높으면 오르막 경사로 가능한지 체크(직전까지 연속길이를 활용)
				if(size<X) return false;
				beforeHeight++;
				size=1;// 새로운 높이이므로 다시 카운팅해야함
				++j;
			}else if(beforeHeight-1==map[i][j]) {// 이전보다 높이가 1 낮으면 내리막 경사로 가능한지 체크
				int count = 0;
				for(int k=j; k<N; ++k) { // 현재 위치부터 다음 계속 보며 경사로 X길이 만큼의 길이가 가능한지 확인 
					if(map[i][k] != beforeHeight-1) break;//이전보다 높이가 1만큼 낮지 않으면 break
					if(++count==X) break; // x길이 만족하면 탈출 
				}
				if(count<X) return false;
				beforeHeight--;
				size = 0;
				j += X; 
			}else { // 높이가 2이상 차이나면 활주로 건설 불가
				return false;
			}
		}
		return true;
	}
	
	private static boolean makeRoadByCol(int i) {
		int beforeHeight = map[0][i],size=1;
		int j = 1;
		while(j<N) {// 두번째 칸부터 처리
			if(beforeHeight==map[j][i]) { // 이전과 높이가 같으면 연속길이 증가
				size++;
				++j;
			}else if(beforeHeight+1==map[j][i]) { // 이전보다 높이가 1높으면 오르막 경사로 가능한지 체크
				if(size<X) return false;
				beforeHeight++;
				size=1;// 새로운 높이이므로 다시 카운팅해야함
				++j;
			}else if(beforeHeight-1==map[j][i]) {// 이전보다 높이가 1 낮으면 내리막 경사로 가능한지 체크
				int count = 0;
				for(int k=j; k<N; ++k) {
					if(map[k][i] != beforeHeight-1) break;//이전보다 높이가 1만큼 낮지 않으면 break
					if(++count==X)break;
				}
				if(count<X) return false;
				beforeHeight--;
				size = 0;
				j += X; 
			}else { // 높이가 2이상 차이나면 활주로 건설 불가
				return false;
			}
		}
		return true;
	}	
}
