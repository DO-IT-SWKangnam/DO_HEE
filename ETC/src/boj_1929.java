import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1929 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int last = Integer.parseInt(st.nextToken());
		for(int i = first; i <= last ; i++) {
			boolean isPrime = true;
			
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(i == 1) isPrime = false;
			if(isPrime) {
				System.out.println(i);
			}
		}
	}
}
