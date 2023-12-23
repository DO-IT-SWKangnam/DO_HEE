import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10845 {
	static int arr[];
	static int pointer;
	static int size;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		arr = new int[tc];
		pointer = 0;
		size = 0;
		
		for(int i = 0 ; i<tc;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command) {
			case("push"):
				int n = Integer.parseInt(st.nextToken());
				arr[size] = n;
				size++;
				break;
			case("pop"):
				if(size-pointer == 0)
					System.out.println(-1);
				else {
					System.out.println(arr[pointer]);
					pointer++;
				}
				break;
			case("size"):
				System.out.println(size-pointer);
				break;
			case("empty"):
				if(size-pointer == 0) System.out.println(1);
				else System.out.println(0);
				break;
			case("front"):
				if(size-pointer == 0)
					System.out.println(-1);
				else {
					System.out.println(arr[pointer]);
				}
				break;
			case("back"):
				if(size-pointer == 0)
					System.out.println(-1);
				else {
					System.out.println(arr[size-1]);
				}
				break;
			}
		}
	}
}
