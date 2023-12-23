import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_10799 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		
		int count = 0;
		for(int j = 0; j < str.length(); j++) {
			if(str.charAt(j) == '(') {
				stack.push(str.charAt(j));
			}
			else  {
				if(str.charAt(j-1) == '(') {
					stack.pop();
					count += stack.size();
				}
				else {
					stack.pop();
					count++;
				}
			}
			
		}
		System.out.print(count);
	}
}
