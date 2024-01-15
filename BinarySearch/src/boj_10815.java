import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10815 {
	static int N, M;
	static long cards[], finds[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N = Integer.parseInt(br.readLine());
		cards = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);
		
		M = Integer.parseInt(br.readLine());
		finds = new long[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M ; i++) {
			finds[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M ; i++) {
			System.out.print(search(finds[i])+ " ");
		}
	}
	
	public static int search(long n) {
		int start = -1;
		int end = N;
		
		while(end - start > 1) {
			int index = (start + end) / 2;
			
			if(cards[index] == n) return 1;
			else if(cards[index] > n) {
				end = index;
			}
			else {
				start = index;
			}
		}
		return 0;
	}
}
