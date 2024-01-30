import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2447 {
	static StringBuilder sb;
	static char arr[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		star(0, 0, N);
		
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void star(int row, int col, int size) {
		if(size == 1) {
			arr[row][col] = '*';
			return;
		}
		
		int newSize = size / 3;
		
		star(row, col, newSize);
		star(row, col + newSize, newSize);
		star(row, col + 2 * newSize, newSize);
		
		star(row+ newSize, col, newSize);
		for(int i = row+newSize; i < row + 2 * newSize; i++) {
			for(int j = col+newSize; j < col + 2 * newSize; j++) {
				arr[i][j]= ' ';
			}
		}
		star(row+ newSize, col + 2 * newSize, newSize);
		
		star(row + 2 * newSize, col, newSize);
		star(row + 2 * newSize, col + newSize, newSize);
		star(row + 2 * newSize, col + 2 * newSize, newSize);
	}
}
