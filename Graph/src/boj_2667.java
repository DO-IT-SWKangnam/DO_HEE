import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
public class boj_2667 {
	static int number, count, size;
	static boolean checked[][];
	static int arr[][];
		
	public static void DFS(int i, int j) {
		if(checked[i][j]||arr[i][j]==0) return;
		checked[i][j] = true;
		count++;
		if(i < size - 1) DFS(i+1, j);
		if(j < size - 1) DFS(i, j+1);
		if(i > 0) DFS(i-1, j);
		if(j > 0) DFS(i, j-1);
	}
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		size = Integer.parseInt(br.readLine());
		checked = new boolean[size][size];
		arr = new int[size][size];
		number = count = 0;
		
		for(int i = 0; i < size ; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		
		ArrayList<Integer> counts = new ArrayList();
		for(int i = 0; i < size ; i++) {
			for(int j = 0; j < size; j++) {
				if(!checked[i][j] && arr[i][j] == 1) {
					count = 0;
					number++;
					DFS(i, j);
					counts.add(count);
				}
			}
		}
		counts.sort(Comparator.naturalOrder());
		
		sb.append(number + "\n");
		for(int i : counts) {
			sb.append(i + "\n");
		}
		System.out.print(sb);
	}
}
