import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj_10844 {
	static long dp[][];

	public static long calc(int n, int index) {
		if(n == 1) return dp[n][index];
		if(dp[n][index] == 0) {
			if(index == 0) dp[n][0]=calc(n-1,1)%1000000000;
		else if(index == 9) dp[n][9]=calc(n-1,8)%1000000000;
		else dp[n][index]=(calc(n-1,index-1)+calc(n-1,index+1))%1000000000;
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
		
		for(int i = 1; i < 10; i++) {
			result += calc(n, i);
		}
		
		System.out.print(result%1000000000);
	}
}

/* 기본 조건 설정을 확실히 합시다..*/