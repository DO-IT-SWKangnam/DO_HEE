import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2875 {
	static int N, M, K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int count = 0;
		
		while(K > 0) {
			if(N >= M && N > M * 2)  N -= 1;
			else M -= 1;
			K--;
		}
		
		
		while(N >= 2 && M >= 1) {
			N -= 2; M -= 1;
			count ++;
		}
		
		System.out.println(count);
	}
}
