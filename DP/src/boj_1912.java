import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1912 {
	static int[] arr;
	static int[] dp;
	
	public static int calc(int n) {
		if(n==0) return dp[0];
		
		if(dp[n]==0) {
			dp[n] = Math.max(arr[n], arr[n]+calc(n-1));
		}
		return dp[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		calc(n - 1);
		
		int max = dp[0];
		for(int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
	
		System.out.println(max);
	}
}
