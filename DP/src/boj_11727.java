import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 

public class boj_11727 {
	static int dp[];
	public static int calc(int n) {
		if(n < 3) return dp[n];
		if(dp[n] > 0) {		
			return dp[n];
		}
		dp[n] = (calc(n-1) + 2 * calc(n-2)) %10007;
		return dp[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		dp = new int[n+2];
		dp[1] = 1;
		dp[2] = 3;
		
		System.out.print(calc(n));
	}
}

/*
 * 두 개나 큰 네모나,, 모양은 같기 때문에 *2로 바꾸고
 * 초기값도 수정
 */
