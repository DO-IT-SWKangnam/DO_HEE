import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1212 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb1 = new StringBuilder();
		
		
		String n = br.readLine();
		
		for(int i = 0; i < n.length(); i++) {
			String str = Integer.toBinaryString(n.charAt(i) - '0'); 
			
			if(str.length() == 2 && i != 0)
                str = "0" + str;
            else if(str.length() == 1 && i !=0)
                str = "00" + str;
			
			sb1.append(str);
		}
		System.out.print(sb1);
	}
}
