import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2146 {
	static int map[][];
	static boolean visited[][];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static int size, min, count;
	
	public static void islandBFS(int x, int y) {
		Queue<int[]> island = new LinkedList<>();
		
		island.add(new int[] {x, y});
		visited[x][y] = true;
		map[x][y] = count;
		
		while(!island.isEmpty()) {
			int[] temp = island.poll();
			for(int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(isRange(nx,ny)) {
					if(map[nx][ny] == 1 && !visited[nx][ny]){
						map[nx][ny] = count;
						island.add(new int[] {nx,ny});
					}
				}
			}
		}
	}
	public static int BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		visited = new boolean[size][size];
		
		int num = map[x][y];
		visited[x][y] =true;
		queue.add(new int[] {x,y,0});
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int preX = temp[0];
			int preY = temp[1];
			int preV = temp[2];
			
			if(map[preX][preY] != 0 && map[preX][preY] != num) {
				return preV;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = preX + dx[i];
				int ny = preY + dy[i];

				if(isRange(nx,ny)) {
					if(!visited[nx][ny] && map[nx][ny] != num) {
						visited[nx][ny] = true;
						queue.add(new int[] {nx,ny, preV+1});
					}
					
				}
			}
		}
		return -1;
	}
	public static boolean isRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < size && ny < size;
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		visited = new boolean[size][size];
		
		for(int i = 0; i < size ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count = 2;
		for(int i = 0; i < size ; i++) {
			for(int j = 0; j < size ; j++) {
				if(map[i][j]==1) {
					islandBFS(i, j);
					count++;
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		for(int i = 0; i < size ; i++) {
			for(int j = 0; j < size ; j++) {
				if(map[i][j] > 0) {
					int res = BFS(i, j);
					if(res == -1 )continue;
					if(min > res) {
						min = res;
					}
				}
			}
		}

		System.out.print(min-1);
	}
}
