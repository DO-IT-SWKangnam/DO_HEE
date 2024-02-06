import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class boj_1744 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N  = Integer.parseInt(br.readLine());
		LinkedList<Integer> plus = new LinkedList<>();
		LinkedList<Integer> minus = new LinkedList<>();
		int sum = 0;
		int mul;
		
		for(int i = 0; i < N ; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n > 0) plus.add(n);
			else minus.add(n);
		}
		
		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus);
		
		for(int i = 0; i < plus.size(); i+=2) {
			if(i + 1 >= plus.size()) sum += plus.get(i);
			else if(plus.get(i+1) == 1) {
				sum += plus.get(i) + plus.get(i+1);
			}
			else {
				mul = plus.get(i)*plus.get(i+1);
				sum += mul;
			}
		}
		for(int i = 0; i < minus.size(); i+=2) {
			if(minus.get(i)==0 || i + 1 >= minus.size()) sum += minus.get(i);
			else {
				mul = minus.get(i)*minus.get(i+1);
				sum += mul;
			}
		}
		
		System.out.print(sum);
	}
}
