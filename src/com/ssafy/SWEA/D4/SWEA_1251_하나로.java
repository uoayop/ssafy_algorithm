package com.ssafy.SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 

// 프림 알고리즘 사용
public class SWEA_1251_하나로 {
	public final static long MAX_VALUE = Long.MAX_VALUE;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int t=1; t<=T; t++) {
            int n = Integer.parseInt(br.readLine()); 		// n : 섬의 개수
            long[][] distance = new long[n][n]; 			// distance[][] : 섬 사이의 거리 저장
            int[][] island = new int[n][2]; 				// island[][] : 섬들의 좌표 저장
             
            boolean[] visited = new boolean[n];			// visited[] : 섬에 대한 방문 체크
            long[] minDistance = new long[n];			// minDistance[] : 가장 짧은 간선을 찾아 저장
            Arrays.fill(minDistance, MAX_VALUE);
             
            StringTokenizer x = new StringTokenizer(br.readLine()); // x 좌표 입력
            StringTokenizer y = new StringTokenizer(br.readLine()); // y 좌표 입력
             
            for(int i=0; i<n; i++) {
            	// 섬 i의 x 좌표, y 좌표 저장
                island[i][0]=Integer.parseInt(x.nextToken());
                island[i][1]=Integer.parseInt(y.nextToken());
            }
             
            // 각 섬을 연결할 때의 간선 길이를 distance에 저장
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                	int x1 = island[i][0], y1 = island[i][1];
                	int x2 = island[j][0], y2 = island[j][1];
                	
                    long dist = getDistance(x1, y1, x2, y2);
                    
                    distance[i][j] = dist;	// 무방향 그래프
                    distance[j][i] = dist;
                }
            }
             
            double E = Double.parseDouble(br.readLine()); // E: 환경 부담 세율
             
            long result=0, min=0;
            minDistance[0] = 0; // 임의의 시작점 0의 간선비용을 0으로 세팅
             
            for(int i=0; i<n; i++) {
                // 1. 신장트리에 포함되지 않은 정점 중 최소간선비용의 정점 찾기
                min = MAX_VALUE;
                int minVertex=-1; // 최소간선비용의 정점번호
                for(int j=0; j<n; j++) {
                    if(!visited[j] && min > minDistance[j]) {
                        min = minDistance[j];
                        minVertex=j;
                    }
                }
                 
                visited[minVertex] = true;  // 신장트리에 포함시킴
                 
                // 2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선비용 최소로 업데이트
                for(int j=0; j<n; j++) {
                	// 방문하지 않았고, 최소 비용보다 더 작을 경우 갱신
                    if(!visited[j] && minDistance[j] > distance[minVertex][j]) {
                        minDistance[j] = distance[minVertex][j];
                    }
                }
            }
             
            for(int i=0; i<n; i++) {
                result += minDistance[i];	// 간선비용 누적
            }
            
            result = Math.round(result * E);	// 반올림
            System.out.println("#"+t+" "+result);
        }
    }
    
	private static long getDistance(int x1, int y1, int x2, int y2) {
		return (long) (Math.pow(Math.abs(x1-x2),2) + Math.pow(Math.abs(y1-y2), 2));
	}
}

//package com.ssafy.SWEA.D4;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.StringTokenizer;
//
//public class SWEA_1251_하나로 {
//	public static class edge implements Comparable<edge>{
//		int x, y;
//		double cost;
//
//		public edge(int x, int y, double d) {
//			this.x = x;
//			this.y = y;
//			this.cost = d;
//		}
//
//		@Override
//		public int compareTo(edge o) {
//			return Double.compare(cost, o.cost);
//		}
//	}
//	
//	public static int[] parent;
//	
//	public static void make() {
//		parent = new int[n+1];
//		for (int i=0; i<=n; i++) {
//			parent[i] = i;
//		}
//	}
//	
//	public static int findSet(int x) {
//		if(x == parent[x]) return x;
//		return parent[x] = findSet(parent[x]);
//	}
//	
//	public static void union(int x, int y) {
//		int px = findSet(x);
//		int py = findSet(y);
//		
//		if( parent[px] > parent[py] ) {
//			parent[py] = px;
//		} else {
//			parent[px] =py;
//		}
//	}
//	
//	public static int n;
//	public static ArrayList<Integer> x, y;
//	public static double e; 
//	
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int T = Integer.parseInt(br.readLine());
//		for (int t=1; t<=T; t++) {
//			
//			n = Integer.parseInt(br.readLine());
//			
//			x = new ArrayList<>();
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for (int i=0; i<n; i++) {
//				x.add(Integer.parseInt(st.nextToken()));
//			}
//			
//			y = new ArrayList<>();
//			st = new StringTokenizer(br.readLine());
//			for (int i=0; i<n; i++) {
//				y.add(Integer.parseInt(st.nextToken()));
//			}
//			
//			e = Double.parseDouble(br.readLine());
//
//			edge[] islands = new edge[n*(n-1)/2];	// 최대 간선 개수
//			int index = 0;
//			for(int i=0; i<n-1; i++) {
//				for(int j=i+1; j<n; j++) {
//					islands[index++] = new edge(i, j, getDistance(x.get(i), y.get(i), x.get(j), y.get(j)));
//				}
//			}
//			
//			Arrays.sort(islands);
//
//			make();
//			
//			long answer = 0;
//			int cnt = 0;
//			for (int i=0; i<n*(n-1)/2; i++) {
//				int v1 = findSet(islands[i].x);
//				int v2 = findSet(islands[i].y);
//				if(v1==v2) continue;
//				answer += islands[i].cost;
//				union(v1, v2);
//				if(cnt==n-1) break;
//			}
//			
//			System.out.println(Math.round(answer * e));
//		}
//		
//	}
//
//	private static double getDistance(int x1, int y1, int x2, int y2) {
//		return Math.pow(Math.abs(x1-x2) + Math.abs(y1-y2), 2);
//	}
//}
