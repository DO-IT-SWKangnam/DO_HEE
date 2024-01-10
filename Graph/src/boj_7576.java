import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576 {
	static int M, N, count;
	static int tomato[][];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static Queue<int[]> queue = new LinkedList<>();
	
	public static void BFS() {
		while(!queue.isEmpty()) {
			int[] t = queue.poll();
			for(int i = 0; i <4 ; i++) {
				int nx = t[0] + dx[i];
				int ny = t[1] + dy[i];
				if(checkRange(nx,ny)) {
					tomato[nx][ny] = tomato[t[0]][t[1]] + 1;
					queue.add(new int[]{nx, ny});
				}
			}
		}
	}
	
	public static boolean checkRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < M && ny < N && tomato[nx][ny] == 0;
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		tomato = new int[M][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				tomato[j][i] = Integer.parseInt(st.nextToken());
				if(tomato[j][i] == 1) queue.add(new int[]{j, i});
			}
		}
		
		BFS();
		
		count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tomato[j][i]==0) {
					System.out.println(-1);
					return;
				}
				   if (count < tomato[j][i]) {
					   count = tomato[j][i];
                   }
			}
		}
		System.out.println(count-1);
	}
}

/* count를 for문에 넣어 탐색했더니 됨*/