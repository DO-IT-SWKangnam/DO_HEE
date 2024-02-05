import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11047 {
	static int N, K;
	static int coin[];
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coin = new int[N];
		count = 0;
		
		for(int i = 0 ; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int index = N - 1;
		while(K != 0) {
			if(K < coin[index]) {
				index--;
				continue;
			}
			
			K -= coin[index];
			count++;
		}
		
		System.out.print(count);
	}
}
