import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2805 {
	static long trees[];
	static long M;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		trees = new long[N];
		long max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			trees[i] = Long.parseLong(st.nextToken());
			if(max < trees[i]) max = trees[i];
		}
		
		long start = -1;
		long end = max + 1;
		long index = (start + end) / 2;
		while((end - start) > 1) {
			long get = 0;
			for(long tree : trees) {
				if(index < tree) get += tree - index;
			}
			if(get == M) {
				break;
			}
			else if(get > M) {
				start = index;
			}
			else {
				end = index;
			}
			index = (start + end) / 2;
		}
		
		System.out.print(index);
	}
}
