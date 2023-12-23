import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10866 {
	static int arr[];
	static int first;
	static int last;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		arr = new int[tc*2];
		first = tc;
		last = tc;
		
		for(int i = 0 ; i<tc;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command) {
			case("push_front"):
				int n = Integer.parseInt(st.nextToken());
				first--;
				arr[first] = n;
				break;
			case("push_back"):
				int m = Integer.parseInt(st.nextToken());
				arr[last] = m;
				last++;
				break;
			case("pop_front"):
				if(last-first == 0)
					System.out.println(-1);
				else {
					System.out.println(arr[first]);
					first++;
				}
				break;
			case("pop_back"):
				if(last-first == 0)
					System.out.println(-1);
				else {
					System.out.println(arr[last-1]);
					last--;
				}
				break;
			case("size"):
				System.out.println(last-first);
				break;
			case("empty"):
				if(last-first == 0) System.out.println(1);
				else System.out.println(0);
				break;
			case("front"):
				if(last-first == 0)
					System.out.println(-1);
				else {
					System.out.println(arr[first]);
				}
				break;
			case("back"):
				if(last-first == 0)
					System.out.println(-1);
				else {
					System.out.println(arr[last-1]);
				}
				break;
			}
		}
	}
}
