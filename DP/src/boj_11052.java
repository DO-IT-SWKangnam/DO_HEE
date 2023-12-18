import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11052 {
	static int arr[];
	static int dp[];
	
	public static int calc(int n) {
		if(n == 1) return dp[1];
		
		if(dp[n] == 0) {
			dp[n] = arr[n];
			
			for(int i = 1; i < n; i++) {
				dp[n] = Math.max(dp[n], calc(n-i)+arr[i]);
			}
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1]=arr[1];
		calc(n);
		
		int max = 0;
		for(int i = 1; i < n+1; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.print(max);
	}
}