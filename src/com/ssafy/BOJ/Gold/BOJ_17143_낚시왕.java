package com.ssafy.BOJ.Gold;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class BOJ_17143_낚시왕 {
	public static class shark implements Comparable<shark>{
		int x, y, idx, v, d, size;

		public shark(int x, int y, int idx, int v, int d, int size) {
			this.x = x;
			this.y = y;
			this.idx = idx;	// 상어의 고유번호
			this.v = v;
			this.d = d;
			this.size = size;
		}

		@Override
		public int compareTo(shark o) {
			return o.size - size;
		}
	}
	
	public static int[][] dir = {{}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static int[][] map;
	public static int[][] mapCopy;
	public static shark[] sharks;
	public static int r, c, m, answer, sharkCnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());	// 가로
		c = Integer.parseInt(st.nextToken());	// 세로
		m = Integer.parseInt(st.nextToken()); 	// 상어 수

		map = new int[r+1][c+1];	// map[x][y] = i : (x,y) 좌표에 i번 상어가 있다고 표시
		sharks = new shark[m+1];	// sharks[i] : i번 상어의 정보 저장
		sharkCnt = m;				// sharkCnt : 상어가 죽을 때마다 1씩 줄이면서 체크해줄 것임!
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());	
			int y = Integer.parseInt(st.nextToken());	
			int s = Integer.parseInt(st.nextToken()); 	// 속력
			int d = Integer.parseInt(st.nextToken());	// 이동 방향
			int z = Integer.parseInt(st.nextToken()); 	// 크기
			
			if ((d == 1 || d == 2) && r > 1) { s %= ((r-1) * 2); }
			// 위아래로 움직일 때, 벽에 계속 부딪히면서 반복되게 오가는 거리 줄이기
			
			if ((d == 3 || d == 4) && c > 1) { s %= ((c-1) * 2); }
			// 좌우로 움직일 때
			
			map[x][y] = i+1;
			// map에 (x,y) 좌표에 i+1번 상어가 위치한다고 표시
			sharks[i+1] = new shark(x, y, i+1, s, d, z);
		}
		
		for (int ii=1; ii<=r; ii++) {
			for (int j= 1; j<=c; j++) {
				System.out.print(map[ii][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i=1; i<=c; i++) {
			fish(i);					// 1. i번째 열에 있는 상어 잡기
			if (sharkCnt == 0) break;	//   ->  모든 상어를 잡았다면 break
			move();						// 2. 상어 움직이기
			
			System.out.println(">> "+i +" / "+ answer);
			for (int ii=1; ii<=r; ii++) {
				for (int j= 1; j<=c; j++) {
					System.out.print(map[ii][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		bw.write(answer+"\n");
		bw.flush();
	}

	private static void fish(int col) { // col 열에 있는 상어 잡기
		for (int row=1; row<=r; row++) {
			// 위에서부터 상어가 있는지 체크해주고, 상어를 잡으면 break 해줌
			if (map[row][col] > 0) {
				// 상어의 번호는 1부터 시작하므로, map[row][col] 이 0보다 크다는 뜻은 상어가 위치한다는 의미임
				int index = map[row][col];
				// map의 (row, col)에 위치한 상어의 번호 가져오기
				
				shark caught = sharks[index];
				// caught : 잡힌 상어 정보 
				answer += caught.size;
				// 잡힌 상어의 크기를 answer에 더해줌
				
				sharks[index] = null;	// 잡았으니까 상어 배열에서 지우기
				map[row][col] = 0;		// 맵에서도 지우기
				sharkCnt -= 1;			// 상어의 수 -= 1
				return;
			}
		}
	}

	private static void move() {	// 상어들이 d 방향으로 움직임
		mapCopy = new int[r+1][c+1];
		for (int i=0; i<=m; i++) {
			// sharks 배열에서 순차적으로 체크
			if (sharks[i] == null) continue;
			// 만약 i번 상어가 이미 죽었다면 다음 상어 체크
			
			int x = sharks[i].x, y = sharks[i].y, didx = sharks[i].d, vc = sharks[i].v;
			int xx = x, yy = y;
			// x, y : i번 상어의 위치 / didx : 움직이는 방향  / vc : 상어의 이동 속도
			// 위에서 vc가 반복되게 오가는 거리를 생략해줬기 때문에 따로 처리 X
			
//			
			// 상어가 (x,y) 에서 다른 위치로 움직일 것이므로 map에서 번호 지워주기
			
			if (didx == 1 || didx == 2) { // 위아래로 이동
				for (int j=0; j<vc; j++) {
					int nx = x + dir[didx][0];	// 다음 위치 : (nx, ny)
					int ny = y + dir[didx][1];
					
					// 만약 map의 범위를 벗어나면 방향을 바꿔주고, 범위를 재조정
					// 위쪽 방향 <-> 아래쪽 방향
					if (nx < 1) { didx = 2; nx += 2; }
					else if (nx > r) { didx = 1; nx -= 2; }
					x = nx; y = ny;			// 이동한 위치를 현재 좌표로 변경 
				}
			} else {						// 좌우로 이동
				for (int j=0; j<vc; j++) {
					int nx = x + dir[didx][0];	// 다음 위치 : (nx, ny)
					int ny = y + dir[didx][1];
					
					// 만약 map의 범위를 벗어나면 방향을 바꿔주고, 벙위를 재조정
					// 왼쪽 방향 <-> 오른쪽 방향
					if (ny < 1) { didx = 3; ny += 2; }	
					else if (ny > c) { didx = 4; ny -= 2; }
					x = nx; y = ny;			// 이동한 위치를 현재 좌표로 변경
				}
			}
			
			// 이동한 좌표를 현재 상어의 위치로 변경해줌
			sharks[i].x = x;
			sharks[i].y = y;
			sharks[i].d = didx;

			if (mapCopy[x][y] > 0) {
				shark existShark = sharks[mapCopy[x][y]];
				// existShark : 좌표에 이미 존재하는 상어
				if (sharks[i].size > existShark.size) {  // 새 상어의 무게가 더 크면, 기존에 존재하던 상어를 잡아먹음
					mapCopy[x][y] = sharks[i].idx;			// map에 새 상어의 번호를 적음
					sharks[existShark.idx] = null; 		// 새 상어는 죽었으니까 shark 배열에서 지워줌
				} else { 								
					// 기존에 존재하던 상어의 몸무게가 더 크면, 새 상어가 잡아먹힘
					sharks[i] = null;
				}
				
				sharkCnt -= 1; // 둘 중 한마리는 어쨌든 잡아먹히므로 상어의 수를 1 줄여줌
			} else {
				// 만약 이동한 좌표에 상어가 없는 경우 map에 상어의 번호를 적어줌
				mapCopy[x][y] = sharks[i].idx;
			}
//			if (map[x][y] > 0) {
//				// 만약 이동한 좌표에 이미 상어가 있을 경우, 무게가 더 작은 상어가 잡아먹힘
//				shark existShark = sharks[map[x][y]];
//				// existShark : 좌표에 이미 존재하는 상어
//				if (sharks[i].size > existShark.size) {  // 새 상어의 무게가 더 크면, 기존에 존재하던 상어를 잡아먹음
//					map[x][y] = sharks[i].idx;			// map에 새 상어의 번호를 적음
//					sharks[existShark.idx] = null; 		// 새 상어는 죽었으니까 shark 배열에서 지워줌
//				} else { 								
//					// 기존에 존재하던 상어의 몸무게가 더 크면, 새 상어가 잡아먹힘
//					sharks[i] = null;
//				}
//				
//				sharkCnt -= 1; // 둘 중 한마리는 어쨌든 잡아먹히므로 상어의 수를 1 줄여줌
//			} else {
//				// 만약 이동한 좌표에 상어가 없는 경우 map에 상어의 번호를 적어줌
//				map[x][y] = sharks[i].idx;
//			}
		}
		CopyToOrigin();
	}

	private static void CopyToOrigin() {
		
		
		for (int i=0; i<=r; i++) {
			for (int j=0; j<=c; j++) {
				map[i][j] = mapCopy[i][j];
			}
		}
	}
}

/*

4 4 4
1 1 1 2 10
2 1 0 1 1
3 1 1 2 10
4 1 0 1 1
*/
	/*
	public static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	public static class shark implements Comparable<shark>{
		int x, v, dir, size;

		public shark(int x, int v, int dir, int size) {
			this.x = x;
			this.v = v;
			this.dir = dir;
			this.size = size;
		}

		@Override
		public int compareTo(shark o) {
			if (x == o.x)
				return o.size - size;
			return x - o.x;
		}
	}
	
	public static int r, c, m;
	public static ArrayList<shark>[] sharks;
	public static boolean[][] position;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		r = Integer.parseInt(st.nextToken());	// 가로
		c = Integer.parseInt(st.nextToken());	// 세로
		m = Integer.parseInt(st.nextToken()); 	// 상어 수

		sharks = new ArrayList[c];
		for (int i=0; i<c; i++) {
			sharks[i] = new ArrayList<>();
		}
		position = new boolean[r][c];
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());	
			int y = Integer.parseInt(st.nextToken());	
			int s = Integer.parseInt(st.nextToken()); 	// 속력
			int d = Integer.parseInt(st.nextToken());	// 이동 방향
			int z = Integer.parseInt(st.nextToken()); 	// 크기
			sharks[y].add(new shark(x,s,d,z));
			position[x][y] = true;
		}
		
		for (int idx = 0; idx < c; idx++) {
			ArrayList<shark> curr = sharks[idx];
			if (curr.isEmpty()) continue;
			
			Collections.sort(curr);

			shark first = curr.remove(0);
			answer += first.size;
			
			sharkMove();
		}
		
		
	}

	private static void sharkMove() {
		for (int i=0; i<c; i++) {
			if (sharks[i].isEmpty()) continue;
			
			for (int j=0; j<sharks[i].size(); j++) {
				shark curr = sharks[i].remove(0);
				position[curr.x][i] = false;
				
				int dir = curr.dir, cdir = getCounterDir(curr.dir);
				int v = curr.v, newV;
				int currX = curr.x, nextX = curr.x, currY = i, nextY = i;
				
				if (dir == 0 || dir == 1) {
					int toWall = Math.abs((r-1) - currX);
					newV = v - toWall;
					int newDir = (newV / (r-1)) % 2 == 0? -1 : 1;
					int restX = newV % (r-1);
					nextX = currX - (toWall * newDir) + (restX * newDir);
					
				} else {
					int toWall = Math.abs((c-1) - currY);
					newV = v - toWall;
					int newDir = (newV / (c-1)) % 2 == 0? -1 : 1;
					int restY = newV % (c-1);
					nextY = currY - (toWall * newDir) + (restY * newDir);
				}
				
				if (position[nextX][nextY]) {
					
				}
				else sharks[nextY].add(new shark(nextX, curr.v, curr.dir, curr.size));
			}
		}
	}

	private static int getCounterDir(int dir) {
		if (dir == 0) return 1;
		else if (dir == 1) return 0;
		else if (dir == 2) return 3;
		else return 2;
	}
	*/
