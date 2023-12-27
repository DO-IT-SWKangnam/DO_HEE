import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_6588 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[1000001];
		isPrime[0] = isPrime[1] = true;
		for(int i = 2; i < 1000001 ; i++) {
			if (!isPrime[i]) {
                for (int j = i + i; j < isPrime.length; j += i) {
                	isPrime[j] = true;
                }
            }
		}
		
		while(n != 0) {
			boolean goldbach = false;
			
			for(int i = 2; i <= n / 2; i++) {
				if (!isPrime[i] && !isPrime[n - i]) {
					System.out.println(n + " = " + i + " + " + (n - i));
					goldbach = true;
					break;
				}
			}
			
			if(!goldbach)
				System.out.println("Goldbach's conjecture is wrong");
			
			n = Integer.parseInt(br.readLine());
		}
	}
}
