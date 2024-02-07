import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10971 {
	static int cost[][], arr[];
	static boolean[] visited;
	static int N, front;
	static int result = Integer.MAX_VALUE;
	
	public static void dfs(int start ,int now, int cnt) {
		if (cnt == N - 1) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				sum += arr[i];
			}
			if(cost[now][start]==0) return;
			sum += cost[now][start];
            result = Math.min(result, sum);
            return;
        }
		
		visited[now] = true;
		for (int i = 0; i < N; i++) {
            if (visited[i] || cost[now][i] == 0) continue;

            arr[cnt] = cost[now][i];
            dfs(start, i, cnt + 1);
            visited[i] = false;
        }
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		cost = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
			{
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
            dfs(i,i, 0);
        }
		System.out.print(result);
	}
}
