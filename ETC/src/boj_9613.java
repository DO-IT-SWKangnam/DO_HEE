import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9613 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0; i< tc ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int arr[] = new int[n];
			for(int j = 0; j< n ; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0;
			
			for(int j = 0; j< n - 1 ; j++) {
				for(int k = j +1; k < n ; k++) {
					sum += gcd(arr[j], arr[k]);
				}
			}
			System.out.println(sum);
		}
	}
	
	public static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a=b;
			b=r;
		}
		return a;				
	}
}
