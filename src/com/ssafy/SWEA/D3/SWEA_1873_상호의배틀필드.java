// 상호의 배틀필드

package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1873_상호의배틀필드 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static boolean CanGo(int x, int y, int h, int w, char [][]ground) {
		// 전차가 범위 내에 있고, 이동하려는 곳이 평지일 때 true 리턴
		if (0<=x && x<h && 0<=y && y<w && ground[x][y] == '.') return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		class Car{	// 전차 객체
			int dir_x, dir_y;
			int x, y;
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt((st.nextToken()));	// 행
			int w = Integer.parseInt((st.nextToken()));	// 열
			Car car = new Car();
			
			char[][] ground = new char[h][w];
			
			for (int i=0; i<h; i++) {
				ground[i] = br.readLine().toCharArray();	// 맵 입력 받기
				for (int j=0; j<ground[i].length; j++) {
					// 전차 위치를 입력 받으면, 전차 객체에 위치와 방향 저장
					if (ground[i][j] == '^' || ground[i][j] == '>' || ground[i][j] == 'v' || ground[i][j] == '<') {
						car.x = i; car.y = j;
						
						if (ground[i][j] == '^') {	car.dir_x = -1; car.dir_y = 0; } // 상
						else if (ground[i][j] == '>') {	car.dir_x = 0; car.dir_y = 1; } // 우
						else if (ground[i][j] == 'v') {	car.dir_x = 1; car.dir_y = 0; } // 하
						else if (ground[i][j] == '<') {	car.dir_x = 0; car.dir_y = -1; } // 좌
					}
				}
			}
			
			int leng = Integer.parseInt(br.readLine());	// 문자열 길이
			char[] str = br.readLine().toCharArray();	// 문자열
			
			for (char order: str) {
				if (order == 'U') {	// 전차가 위로 이동
					ground[car.x][car.y] = '.';	// 전차 현재 위치를 평지로 바꿈
					car.dir_x = -1; car.dir_y = 0;	// 전차객체의 방향을 바꿔줌
					
					if (CanGo(car.x-1, car.y, h, w, ground)) {	// 전차가 이동할 수 있다면 
						car.x--;								// 전차의 위치 바꿔줌
					}
					ground[car.x][car.y] = '^';					// 현재 맵에서 전차의 방향을 바꿔줌
				} 
				
				else if (order == 'D')  {	// 전차가 아래로 이동
					ground[car.x][car.y] = '.';
					car.dir_x = 1; car.dir_y = 0;
					if (CanGo(car.x+1, car.y,  h, w, ground)) {
						car.x ++;
					}
					ground[car.x][car.y] = 'v';
				} 
				
				else if (order == 'L')  {	// 전차가 왼쪽으로 이동
					ground[car.x][car.y] = '.';
					car.dir_x = 0; car.dir_y = -1;
					if (CanGo(car.x, car.y-1,  h, w, ground)) {
						car.y --;
					}
					ground[car.x][car.y] = '<';
				} 
				
				else if (order == 'R')  {	// 전차가 오른쪽으로 이동
					ground[car.x][car.y] = '.';
					car.dir_x = 0; car.dir_y = 1;
					if (CanGo(car.x, car.y+1,  h, w, ground)) {
						car.y ++;
					}
					ground[car.x][car.y] = '>';
				} 
				
				else if (order == 'S')  {	// 전차가 포탄을 발사
					// 포탄의 위치 bullet_x, bullet_y = 현재 전차의 위치 + 전차의 방향
					int bullet_x = car.x + car.dir_x, bullet_y = car.y + car.dir_y;
					
					while (true) {
						// 포탄이 맵의 범위를 넘어서면 break
						if (0 > bullet_x || bullet_x >= h || 0 > bullet_y || bullet_y >= w) {
							break;
						}
						
						// 포탄이 벽돌로 만들어진 벽에 부딪히면, 평지로 바꿔주고 break
						if (ground[bullet_x][bullet_y] == '*') {
							ground[bullet_x][bullet_y] = '.';
							break;
						}
						// 포탄이 강철로 만들어진 벽에 부딪히면 break
						else if (ground[bullet_x][bullet_y] == '#') {
							break;
						}
						
						// 포탄 이동
						bullet_x += car.dir_x;
						bullet_y += car.dir_y;
					}
				}
			}
			
			// 출력
			bw.write("#"+t+" ");
			for (char[] row: ground) {
				for (char col: row) {
					bw.write(col);
				}
				bw.write('\n');
			}
			bw.flush();
		}
	}
}
