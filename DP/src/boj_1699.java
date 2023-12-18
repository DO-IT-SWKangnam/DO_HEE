import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1699 {
	static int[] dp;
	
	public static void calc(int n) {
		for(int j = 1; j <= n; j++) {
			dp[j]=j;
			for(int i = 1; i*i <= j ; i++) {
				dp[j] = Math.min(1 + dp[j - i*i], dp[j]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		
		dp[1]=1;
		calc(n);
		System.out.print(dp[n]);
	}
}

/* 최소값 고려 x */