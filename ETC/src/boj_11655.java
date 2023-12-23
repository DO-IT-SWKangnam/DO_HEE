import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_11655 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringBuilder sb = new StringBuilder(str);
		
		for(int i = 0; i < str.length() ; i++) {
			char c = str.charAt(i);
			if(Character.isUpperCase(c)) {
				int n = c + 13;
				if(n > 90) n -= 26;
				
				sb.setCharAt(i, (char)n);
			}
			else if(Character.isLowerCase(c)) {
				int n = c + 13;
				if(n > 122) n -= 26;
				
				sb.setCharAt(i, (char)n);
			}
		}
		
		System.out.print(sb);
	}
}
