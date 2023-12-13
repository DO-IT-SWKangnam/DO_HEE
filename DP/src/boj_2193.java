import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class boj_2193 {
	static long bp[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		bp = new long[n+1];
		
		bp[0]=0;
		bp[1] = 1;
		for(int i = 3; i < n+1; i++) {
			bp[i] = bp[i-1]+bp[i-2];
		}
		
		System.out.print(bp[n]);
	}
}

/* ㅎㅎ.. 자료형 long으로 하기~*/
