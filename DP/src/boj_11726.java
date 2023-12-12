import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 

public class boj_11726 {
	static int dp[];
	public static int calc(int n) {
		if(n < 3) return dp[n];
		if(dp[n] > 0) {		
			return dp[n];
		}
		dp[n] = (calc(n-1) + calc(n-2)) %10007;
		return dp[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		
		System.out.print(calc(n));
	}
}

/*	틀렸다고 해서.. 내 갓벽한 알고리즘이 틀릴 리가 업는데..
 * 문제는 출력할 때 10007을 나누어서 그런 거였음,, 출력을 그렇게 하라며어
 *  
 *  Top down 형식으로 풀었는데 이거는 Bottom up이 더 간결했을 듯
 *  */
