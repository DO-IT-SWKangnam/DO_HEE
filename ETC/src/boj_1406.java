import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
public class boj_1406 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int tc = Integer.parseInt(br.readLine());

		LinkedList<Character> list = new LinkedList<Character>();

		for(int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}

		ListIterator<Character> itr = list.listIterator();
		while(itr.hasNext()) {
			itr.next();
		}
	
		
		for(int i = 0; i < tc; i++) {
			String command = br.readLine();
			char c = command.charAt(0);
			
			switch(c) {
			case 'L':
				if(itr.hasPrevious()) itr.previous();
				break;
			case 'D':
				if(itr.hasNext()) itr.next();
				break;
			case 'B':
				if(itr.hasPrevious()) {
					itr.previous();
					itr.remove();
				}
				break;
			case 'P':
				char n = command.charAt(2);
				itr.add(n);				
				break;
			default:
				break;
			}
		}
		
		for(Character chr : list)  {
			sb.append(chr);
		}
		System.out.println(sb);
	}
}
