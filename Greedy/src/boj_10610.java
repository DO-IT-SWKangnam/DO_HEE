import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_10610 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String N = br.readLine();
		
		if(!N.contains("0")) {
			System.out.print(-1);
			return;
		}
        
        int sort[] = new int[N.length()];
        int sum = 0;
        
		for(int i = 0; i < N.length(); i++) {
			sort[i] = N.charAt(i)-'0';
			sum += sort[i];
		}
		
		Arrays.sort(sort);
		
		if(sum % 3 == 0) {
			for(int i = N.length()-1;i>-1;i--) {
				sb.append(sort[i]);
			}
			System.out.print(sb);
		}
		else System.out.print(-1);
	}
}
