import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_10809 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int arr[] = new int[26];
		Arrays.fill(arr, -1);
		
		for(int i = 0; i < str.length() ; i++) {
			int n = str.charAt(i)-'a';
			if(arr[n]==-1) {
				arr[n] = i;
			}
		}
		
		for(int j:arr) {
			System.out.print(j + " ");
		}
	}
}
