import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10825 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String arr[][]= new String[n][4];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken()+"";
			arr[i][1] = st.nextToken(); //국어
			arr[i][2] = st.nextToken(); //영어
			arr[i][3] = st.nextToken(); //수학
		}
		
		Arrays.sort(arr, (a1, a2)-> {
			int num1[]= new int[4];
			int num2[]= new int[4];
				num1[1] = Integer.parseInt(a1[1]);
				num1[2] = Integer.parseInt(a1[2]);
				num1[3] = Integer.parseInt(a1[3]);
				num2[1] = Integer.parseInt(a2[1]);
				num2[2] = Integer.parseInt(a2[2]);
				num2[3] = Integer.parseInt(a2[3]);
			if(num2[1]==num1[1] && num2[2]==num1[2]&& num2[3]==num1[3])
				return a1[0].compareTo(a2[0]);	
			else if(num2[1]==num1[1] && num2[2]==num1[2])
				return num2[3]-num1[3];
			else if(num2[1]==num1[1])
				return num1[2]-num2[2];
			else 
				return Integer.parseInt(a2[1])-Integer.parseInt(a1[1]);
		});
	
		for(int i=0; i<n; i++) {
			sb.append(arr[i][0]).append('\n');
		}
		
		System.out.println(sb);
	}
}

 