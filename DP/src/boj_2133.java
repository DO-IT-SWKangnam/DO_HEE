import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2133 {
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		
		if(n%2==1) {
			System.out.print(0);
			return;
		}
		
		dp[0]=1;
		if(n > 1) dp[2] = 3;
		for(int i = 4; i <=n;i+=2) {
			dp[i] = dp[i-2]*dp[2];
			for(int j = i-4; j >= 0 ; j-= 2) {
				dp[i] += dp[j]*2;
			}
		}
		
		System.out.print(dp[n]);
	}
}

/* 예외 처리에서 시간이 좀 걸렸다.. */