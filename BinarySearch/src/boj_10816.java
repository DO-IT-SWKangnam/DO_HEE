import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10816 {
	static int N, M;
	static long cards[], finds[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		cards = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			cards[i]= Long.parseLong(st.nextToken());
		}
		Arrays.sort(cards);
		
		M = Integer.parseInt(br.readLine());
		finds = new long[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M ; i++) {
			long key = Long.parseLong(st.nextToken());
			sb.append(endSearch(key)-startSearch(key)).append(' ');
			
		}
		System.out.print(sb);
	}
	
	public static int startSearch(long n) {
		int start = 0;
		int end = N;
		
		while(start < end) {
			int index = (start + end) / 2;
			
			if(cards[index] >= n) {
				end = index;
			}
			else {
				start = index +1 ;
			}
		}
		return start;
	}
	public static int endSearch(long n) {
		int start = 0;
		int end = N;
		
		while(start < end) {
			int index = (start + end) / 2;
			
			if(cards[index] <= n) {
				start = index +1 ;
			}
			else {
				end = index;
			}
		}
		return start;
	}
}

/* ¹º°¡ µðÅ×ÀÏ¿¡¼­ »ß²Ù..*/
