import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2110 {
	static int N, C;
	static long houses[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		houses = new long[N];
		
		for(int i = 0; i < N ; i++) {
			houses[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(houses);
		
		long start = 1;
		long end = houses[N - 1] - houses[0] +1 ;
		long index = (start + end) / 2;
		while(end - start > 1) {
			int count = 1;
			long last = houses[0];
			for(long house : houses) {
				if(house - last >= index) {
					count++;
					last = house;
				}
			}
			
			
			if(count >= C) {
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
