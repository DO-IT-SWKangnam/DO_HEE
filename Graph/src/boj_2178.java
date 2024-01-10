import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178 {
	static int M, N;
	static int map[][];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	
	public static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			for(int i = 0; i <4 ; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if(checkRange(nx,ny)) {
					if(map[nx][ny] == 1) {
						map[nx][ny] = map[temp[0]][temp[1]] + 1;
						queue.add(new int[]{nx, ny});
					}
					
				}
			}
		}
	}
	public static boolean checkRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 0;
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M;j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		BFS();
		
		System.out.print(map[N-1][M-1]);
	}
}
