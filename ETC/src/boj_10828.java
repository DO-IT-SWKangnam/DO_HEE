import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10828 {
	static int arr[];
	static int size;
	
	public static void push(int n) {
		arr[size] = n;
		size++;
	}
	public static void top() {
		if(size == 0 ||arr[size - 1] == 0) System.out.println(-1);
		else  System.out.println(arr[size-1]);
	}
	public static void pop() {
		if(size == 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(arr[size - 1]);
		arr[size - 1] = 0;
		size--;
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr= new int[n];
		size = 0;
		
		for(int i = 0; i < n ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command) {
			case("push"):
				int n1 = Integer.parseInt(st.nextToken());
				push(n1);
				break;
			case("pop"):
				pop();
				break;
			case("size"):
				System.out.println(size);
				break;
			case("empty"):
				if(size == 0) System.out.println(1);
				else System.out.println(0); 
				break;
			case("top"):
				top(); 
				break;
			}
		}
	}
}
