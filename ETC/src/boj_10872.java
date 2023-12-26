import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class boj_10872 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		BigInteger result = new BigInteger("1");
		for(int i = 1;i <= n; i++)
			result = result.multiply(BigInteger.valueOf(i));

		String str = result.toString();
		int count = 0;
		for(int i = str.length() - 1;i >= 0; i--) {
			if(str.charAt(i) == '0') {
				count++;
			}
			else break;
		}
		System.out.println(count);
	}
}
