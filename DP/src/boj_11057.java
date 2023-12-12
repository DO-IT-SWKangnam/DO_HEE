
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj_11057 {
	static long dp[][];
	static long mod = 10007;

	public static long calc(int n, int index) {
		if(n == 1) return dp[1][index];
		
		if(dp[n][index] == 0) {
			for(int i = index; i < 10 ;i++ ) {
				dp[n][index] += calc(n-1,i)%mod;
			}
		}
		return dp[n][index];
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dp = new long[n+1][10];
		
		for(int i = 0; i < 10; i++) {
			dp[1][i]= 1l;
		}

		long result = 0;
		
		for(int i = 0; i < 10; i++) {
			result += calc(n, i);
		}
		
		System.out.print(result%mod);
	}
}

/* 10844와 비슷한 알고리즘*/