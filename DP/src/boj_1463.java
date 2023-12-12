import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class boj_1463 {
	static int[] dp;
	
	public static int calc(int n) {
		if(n ==1 || n < 1) {
			return 0;
		}
         if (dp[n] > 0) {
    	return dp[n];
    }
		if((n %6) == 0) {
			dp[n]= 1 + Math.min(calc(n/3), Math.min(calc(n/2), calc(n-1)));
		}
		else if((n %3) == 0) {
			dp[n]= 1 + Math.min(calc(n/3), calc(n-1));
		}
		else if((n % 2) == 0) {
			dp[n]= 1 + Math.min(calc(n/2), calc(n-1));
		}
		else {
			dp[n] = 1 + calc(n-1);
		}
		
		return dp[n];
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
        dp = new int[n+1];
		dp[0] = dp[1] = 0;
		System.out.print(calc(n));
	}
}

/*
 * 1. 최소값 고려 x
 * 2. 시간 초과
 * 		- Memorization 활용을 못한 것으로 예상하고 dp 추가 -> x
 * 		- 6의 경우? -->x
 * 		- 메모라이제이션을 활용 못한 것이 맞았음 -> 탐색을 했는 지 안했는지 구별을 안해놓았었음,, ㅏㅂ보
 *  */