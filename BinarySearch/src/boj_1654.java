import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1654 {
	static long lines[];
	static int K, N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lines = new long[K];
		long max = 0;
		
		for(int i = 0; i < K ; i++) {
			lines[i] = Integer.parseInt(br.readLine());
			if(max < lines[i]) max = lines[i];
		}
		
		long start = 1;
		long end = max + 1;
		long index = (start + end) / 2;
		while(end - start > 1) {
			int count = 0;
			for(long line: lines) {
				count += line / index;
			}
			
			if(count >= N) {
				start = index;
				index = (start + end) / 2;
			}
			else {
				end = index;
				index = (start + end) / 2;
			}
		}
		System.out.print(index);
	}
}
