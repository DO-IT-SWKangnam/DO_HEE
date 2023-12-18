import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9461 {
static long[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		int n;
		dp = new long[101];
		for(int i=0; i<tc;i++) {
			n = Integer.parseInt(br.readLine());
			
			dp[1] = dp[2] = dp[3] = 1;
			
			for(int j = 4; j <= n ; j++) {
				dp[j] = dp[j-3]+dp[j-2];
			}
			
			System.out.println(dp[n]);
		}
	}
}
