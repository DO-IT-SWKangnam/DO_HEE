import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_11005 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		List<Character> list = new ArrayList<>();
	       while (n > 0) {
	           if (n % b < 10) {
	               list.add((char) (n % b + '0'));
	           }
	           else{
	               list.add((char) (n % b - 10 + 'A'));
	           }

	           n /= b;
	       }

	       for (int i = list.size() - 1; i >= 0; i--) {
	           System.out.print(list.get(i));
	       }
	}
}

/* List 안 쓰고 Stringbuilder 쓰다가 계속 틀리길래 List 썼더니 됐으 */
