import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_10820 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[4]; //소문자, 대문자, 숫자, 공백
		String str;
		
		while ((str = br.readLine()) != null) {
			Arrays.fill(arr, 0);
			
			for(int j = 0; j< str.length();j++) {
				int n = str.charAt(j);
				if(n > 96 && n < 123) arr[0]++;
				else if(n > 64 && n < 91) arr[1]++;
				else if(n > 47 && n < 58) arr[2]++;
				if(n == 32) arr[3]++;
			}
			
			for(int k:arr) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
}

