import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class JW_1681_해밀턴순환회로 {
	public static int n, map[][], ans = Integer.MAX_VALUE;
	public static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n];
		
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<n; i++) {
			visited[0] = true;
			
			if (map[0][i]!=0) {
				visited[i] = true;
				go(i, 2, map[0][i]);
				visited[i] = false;
			}
		}
		
		bw.write(ans+"\n");
		bw.flush();
	}

	private static void go(int curr, int cnt, int price) {
		if (cnt == n) {
			if (map[curr][0]!=0) {
				ans = Math.min(ans, price+map[curr][0]);
			}
			return;
		}
		
		if (price > ans) return;
		
		for (int i=0; i<n; i++) {
			if (visited[i]) continue;
			
			if (map[curr][i] == 0) continue;
			
			visited[i] = true;
			go(i, cnt+1, price + map[curr][i]);
			visited[i] = false;
		}
	}
}

/*
5
0 14 4 10 20 
14 0 7 8 7 
4 5 0 7 16 
11 7 9 0 2 
18 7 17 4 0
*/