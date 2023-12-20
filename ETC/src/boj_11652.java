import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj_11652 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		HashMap<Long,Integer> map = new HashMap<Long,Integer>();
		
		for(int i = 0; i < n ;i++) {
			long n1 = Long.parseLong(br.readLine());
			if(map.get(n1) == null) map.put(n1, 1);
			else map.put(n1, map.get(n1)+1);
		}
		
		int max =-1;
		long  answer = 0;
		for(long x: map.keySet()) {
			if(map.get(x) > max) {
				max = map.get(x);
				answer = x;
			} else if(map.get(x) == max) {
				answer = Math.min(answer, x);
			}	
		}
		
		System.out.println(answer);
		
	}
}
