import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1476 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int index = 0;
		while(true) {
			int N = S + (28*index);
			
			int Emod = N % 15;
			int Mmod = N % 19;
			if(Emod == (E % 15) && Mmod == (M % 19)) {
				System.out.print(N);
				return;
			}
			else index++;
		}
	}
}
