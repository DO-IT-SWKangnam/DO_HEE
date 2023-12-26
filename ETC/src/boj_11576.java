import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_11576 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st1.nextToken());
		int B = Integer.parseInt(st1.nextToken());
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int Ato10 = 0;
		for(int i = 0; i < tc ; i++) {
			int n = Integer.parseInt(st2.nextToken());
			Ato10 += n * Math.pow(A, tc-1-i);
			
		}
		
		Stack<Integer> stack = new Stack<>();
		while (Ato10 != 0) {
            stack.push(Ato10 % B);
            Ato10 /= B;
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
	}
}
