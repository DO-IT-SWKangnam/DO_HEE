import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2579 {
	static int[] arr;
	static int[] dp;
	
	public static int calc(int n) {
		if(n < 3) return dp[n];
		
		if(dp[n]==0) {
			dp[n] = Math.max(calc(n-2), arr[n-1]+calc(n-3))+arr[n];
		}
		return dp[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1];
		
		for(int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1]=arr[1];
		if(n > 1) dp[2]=arr[1]+arr[2];

		System.out.print(calc(n));
	}
}

/* 2156°ú À¯»ç */