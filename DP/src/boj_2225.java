import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2225 {
	static long[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int index = Integer.parseInt(st.nextToken());

		dp = new long[n+1][index+1];
		for(int i=0;i<=n;i++){
            dp[i][0] = 0;
            dp[i][1] = 1;
		}
		
		for(int i=0;i<=index;i++){
            dp[1][i] = i;
        }
		
		for(int i=2;i<=n;i++){
            for(int j=2;j<=index;j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
		}
		
		 System.out.println(dp[n][index]);
	}
}

/* 다시 풀어보기 */
