import java.util.*;
import java.math.*;
public class boj_11055 {
	
	static int dp[],cost[] ;
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		//dp �迭�� ���迭 ����
		dp = new int[n+1];
		cost = new int[n+1];
        
		for(int i=1;i<=n;i++) {
			cost[i] = sc.nextInt();
		}
		
		dp[1] = cost[1]; // dp[1]�� �׻� cost[1]�� �ʱ�ȭ �ȴ�. ������ ������ ���� ���� ����
		
		for(int i=2;i<=n;i++) { //�� ��° ���ڸ� �������� n���� �ݺ�
			dp[i] = cost[i]; // �켱 �ڽ��� ���� dp�� ������ �д�.
			for(int j=1;j<i;j++) { // ù ��° ���� i���� ���� �񱳸� ���� �ݺ�
				if(cost[i]>cost[j]) { // ���ذ��� �� ū ���
					dp[i] = Math.max(dp[j]+cost[i],dp[i]); // ���� �����̹Ƿ� dp�� ����
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			if(dp[i]>max) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
	
}

/* �ٽ� �غ���~*/