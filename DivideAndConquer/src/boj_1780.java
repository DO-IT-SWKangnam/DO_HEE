import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1780 {
	static int arr[][];
	static int count[] = new int[3];
	
	class Point {
		public int a;
		public int b;
		public Point(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, N);
		
		for(int i = 0; i < 3; i++) {
			System.out.println(count[i]);
		}
	}
	
	static void divide(int row, int col, int size) {
		if(colorCheck(row, col, size)) {
			if(arr[row][col] == -1) { 
				count[0]++;
			}
			else if(arr[row][col] == 0) {
				count[1]++;
			}
			else {
				count[2]++;
			}
 
			return;
		}
		
		int newSize = size / 3;
		
		divide(row, col, newSize);								
		divide(row, col + newSize, newSize);						
		divide(row, col + 2 * newSize, newSize);					
		
		divide(row + newSize, col, newSize);						
		divide(row + newSize, col + newSize, newSize);			
		divide(row + newSize, col + 2 * newSize, newSize);		
		
		divide(row + 2 * newSize, col, newSize);					
		divide(row + 2 * newSize, col + newSize, newSize);		
		divide(row + 2 * newSize, col + 2 * newSize, newSize);	
	}
	
	static boolean colorCheck(int row, int col, int size) {
		int color = arr[row][col];
		
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (color != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
