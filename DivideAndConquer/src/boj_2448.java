import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2448 {
	static StringBuilder sb;
	static char arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][2*N -1];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2*N - 1; j++) {
				arr[i][j] = ' ';
			}
		}
		
		star(0, 0, N);
		
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < 2*N - 1; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void star(int row, int col, int size) {
		if(size == 3) {
			arr[row][col+2] = '*';
			arr[row+1][col+1] = '*';
			arr[row+1][col+3] = '*';
			for(int i = col; i < col + 5; i++) {
				arr[row+2][i] = '*';
			}
			return;
		}
		
		int newSize = size / 2;
		
		star(row, col+newSize, newSize);
		star(row + newSize, col, newSize);
		star(row + newSize, col + size, newSize);
	};
}
