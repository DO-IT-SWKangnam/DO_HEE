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

/*	Ʋ�ȴٰ� �ؼ�.. �� ������ �˰����� Ʋ�� ���� ���µ�..
 * ������ ����� �� 10007�� ����� �׷� �ſ���,, ����� �׷��� �϶���
 *  
 *  Top down �������� Ǯ���µ� �̰Ŵ� Bottom up�� �� �������� ��
 *  */
