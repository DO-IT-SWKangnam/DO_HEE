import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1992 {
	static int arr[][];
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N ; i++) {
			String str[] = br.readLine().split("");
			for(int j = 0; j < N ; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		divide(0, 0, N);
		
		System.out.print(sb);
	}
	
	static void divide(int row, int col, int size) {
		if(colorCheck(row, col, size)) {
			sb.append(arr[row][col]);
			return;
		}
		
		int newSize = size / 2;
		sb.append("(");
		
		divide(row, col, newSize);
		divide(row, col+newSize, newSize);
		divide(row+newSize, col, newSize);
		divide(row+newSize, col+newSize, newSize);
		sb.append(")");
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
