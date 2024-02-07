import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_10819 {
	static int N, result = 0;
	static int[] num, arr;
	static boolean[] visited;
	
	public static void dfs(int cnt) {
		if (cnt == N) {
            result = Math.max(result, getSum());
            return;
        }
		
		for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            arr[cnt] = num[i];
            dfs(cnt + 1);
            visited[i] = false;
        }
	}
	
	public static int getSum() {
		int sum = 0;
		
		for(int i = 0; i< arr.length - 1;i++) {
			sum += Math.abs(arr[i]-arr[i + 1]);
		}
		
		return sum;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		num = new int[N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
			
		 System.out.println(result);	
	}
}
