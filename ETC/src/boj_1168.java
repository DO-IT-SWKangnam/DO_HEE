import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1168 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int value = Integer.parseInt(st.nextToken())-1;

		ArrayList<Integer> list = new ArrayList<>();
	        
	    for (int i = 1; i <= n; i++) {
	        list.add(i);
	    }
	    
	    int index = 0;
		sb.append("<");
	    for(int i = 0; i < n ; i++) {
	    	if(list.size()==1) {
            	sb.append(list.remove(0)+">");
            	break;
            }
	    	index += value;
            
            if (index >= list.size()) {
                index %= list.size();
            }
       
            sb.append(list.remove(index) + ", ");
	    }
		
		System.out.print(sb);
	}
}
