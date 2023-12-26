import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1373 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String n = st.nextToken();
		List<Integer> list = new ArrayList<>();
		  
		
		int sum = 0;
		int count = 0;
		
		for(int i = n.length()-1; i >= 0 ; i--) {
			int num = n.charAt(i) - '0';
            sum += num * Math.pow(2, count);
            count++;
            if(count == 3 || i == 0) {
				list.add(sum);
				sum = count = 0;
			}
		}
		
		for(int i = list.size()-1; i >= 0 ; i--) {
			System.out.print(list.get(i));
		}
	}
}
