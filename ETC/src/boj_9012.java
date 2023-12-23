import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_9012 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < tc ;i++) {
			String command = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			
			for(int j = 0; j < command.length(); j++) {
				if(command.charAt(j) == '(') {
					stack.push(command.charAt(j));
				}
				else if(stack.empty()) {
					stack.push(command.charAt(j));
					break;
				}
				else {
					stack.pop();
				}
			}
			
			if(stack.empty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
