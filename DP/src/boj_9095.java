import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj_9095 {
	static int dp[]= new int[12];
	
	public static int calc(int n) {
		if(n < 4 || dp[n] > 0) return dp[n];
		dp[n] = calc(n-1) + calc(n-2)+ calc(n-3);
		return dp[n];
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		int n;
		
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		for(int i = 0; i<tc; i++) {
			n = Integer.parseInt(br.readLine());
			
			System.out.println(calc(n));
		}
	}
}

/*
 * 순간 1개는 안되는 건가 헷갈려서 헤멜 뻔하다가 다행이 금방 점화식 짬
 */
