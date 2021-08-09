import java.io.*;
import java.util.*;

public class Solution{
	
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    static int n;
    static int[][] arr;
    static int[][] visit;
    static int answer;
    static int m=987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tt=1; tt<=T; tt++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visit = new int[n][n];	// boolean 형이 아닌 int 형으로 각 좌표에서 이동한 횟수를 저장해줌
            
            
            answer = 0;
            m=987654321;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }
             
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    answer = Math.max(answer , dfs(i,j));
                }
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(visit[i][j]==answer){
                        m=Math.min(m,arr[i][j]);
                    }
                }
            }
            System.out.printf("#%d %d %d\n",tt, m, answer);
        }
    }
    private static int dfs(int r, int c){
        if(visit[r][c]!=0) 
            return visit[r][c];
        
        visit[r][c]=1;
        
        for(int i=0; i<4; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            
            if( 0<=nr && nr<n && 0<=nc && nc<n && arr[nr][nc]-arr[r][c]==1 ){
            	// 이미 방문한 곳은 한번 더 방문 안하도록 해줌 
            	// = dp 테이블을 만들어주기
            	
                visit[r][c]=Math.max(visit[r][c], dfs(nr,nc)+1);
            }
        }
        return visit[r][c];
    }
}