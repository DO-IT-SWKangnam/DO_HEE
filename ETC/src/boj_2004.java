import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2004 {
	public static long getGcd(long n, int value) {
		long count = 0;
		
		while(n >= value) {
			count += n/value;
			n /= value;
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long two = getGcd(n, 2) - getGcd(n-m, 2) - getGcd(m, 2);
		long five = getGcd(n, 5) - getGcd(n-m, 5) - getGcd(m, 5);
		
		long result = Math.min(two, five);
		System.out.println(result);
	}
}
