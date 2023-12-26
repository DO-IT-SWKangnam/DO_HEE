import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2745 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		
		for(int i = 0; i < n.length() ; i++) {
			char c = n.charAt(i);
			int num;
            if (c>='0' && c<='9')
                num = c - '0';
            else
                num = c - 55;
            sum += num * Math.pow(b, n.length()-i - 1);
		}
		
		System.out.print(sum);
	}
}
