import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2004 {
	public static long getGcd(long n, int value) {
		long count = 0;
		while(n != 0 && n % value == 0) {
			count++;
			n /= value;
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long son[] = new long[2];
		for(long i = m + 1l; i <= n ; i++) {
			son[0] += getGcd(i, 2);
			son[1] += getGcd(i, 5);
		}
		
		long mom[] = new long[2];
		for(long i = 1; i <= n - m ; i++) {
			mom[0] += getGcd(i, 2);
			mom[1] += getGcd(i, 5);
		}
		son[0] -= mom[0];
		son[1] -= mom[1];
		
		long result = Math.min(son[0], son[1]);
		System.out.println(result);
	}
}
