import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11054 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] u_dp = new int[n]; //up
		int[] d_dp = new int[n]; //down
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			u_dp[i] = 1;
		    
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && u_dp[i] < u_dp[j] + 1) {
					u_dp[i] = u_dp[j] + 1;	
				}
			}
		}
		
		//작아지는 수열, 뒤부터 탐색
		for (int i = n - 1; i >= 0; i--) {
			d_dp[i] = 1;
			for (int j = n - 1; j > i; j--) {
				if (arr[j] < arr[i] && d_dp[i] < d_dp[j] + 1) {
					d_dp[i] = d_dp[j] + 1;	
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(max < u_dp[i] + d_dp[i]) {
				max = u_dp[i] + d_dp[i];
			}
		}
 
		System.out.println(max - 1);
	}
}
