import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_4963 {
	static int[] dx = {0,0,-1,1,-1,-1,1,1};
	static int[] dy = {-1,1,0,0,-1,1,-1,1};
	static int W, H, count;
	static int arr[][];
	static boolean checked[][];
	
	public static void DFS(int i, int j) {
		checked[i][j] = true;
		
		for(int n=0;n<8;n++) {
			int nx = dx[n]+i;
			int ny = dy[n]+j;
			
			if(nx>=0 && ny>=0 && nx<H && ny<W ) {
				if(!checked[nx][ny] && arr[nx][ny]==1) {
					DFS(nx,ny);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		while(true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W == 0 && H == 0) break;
			
			arr = new int[H][W];
			checked = new boolean[H][W];
			count = 0;
			
			for(int i = 0; i < H ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < H ; i++) {
				for(int j = 0; j < W; j++) {
					if(arr[i][j] != 0 && !checked[i][j]) {
						DFS(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
