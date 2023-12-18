import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2011 {
	static int MOD = 1000000;
	static long dp[];
	
	public static void main(String[] args) throws IOException {
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n =br.readLine();
		dp = new long[n.length()+1];
		dp[0] = 1;
		
		for (int i = 1; i <= n.length(); i++) {
            int one = n.charAt(i-1) - '0';
            if (one >= 1 && one <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }
 
            if(i == 1) continue;
 
            int two = n.charAt(i - 2) - '0';
 
            if(two == 0) continue;
 
            int ten = two * 10 + one;
 
            if (ten >= 10 && ten <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[n.length()]);
	}
}

/* 형변환 떄문에 삽질함*/
