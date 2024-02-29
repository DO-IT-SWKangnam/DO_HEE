import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1012 {
	static int map[][];
	static int M, N, count;
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};

	public static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {x, y});
		map[x][y] = 2;
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];;
				if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
					if(map[nx][ny] == 1) {
						q.offer(new int[] {nx, ny});
						map[nx][ny] = 2;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			count = 0;
			
			while(K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
			}
			
			for(int i = 0; i <M; i++) {
				for(int j =0; j < N; j++) {
					if(map[i][j]==1) {
						BFS(i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}
}
