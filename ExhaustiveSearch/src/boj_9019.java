import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_9019 {
	static int MAX = 10000;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		boolean visited[];
		String command[];
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			Queue<Integer> q = new LinkedList<>();
			visited = new boolean[MAX];
			command = new String[MAX];
			
			q.offer(A);
			visited[A] = true;
			command[A] = "";
			
			while(!q.isEmpty()) {
				int n = q.poll();
				
				if(n == B) {
					System.out.println(command[n]);
					break;
				}
				
				int next = D(n);
				if(!visited[next]) {
					visited[next] = true;
					command[next] = command[n]+ "D";
					q.offer(next);
				}
				next = S(n);
				if(!visited[next]) {
					visited[next] = true;
					command[next] = command[n]+"S";
					q.offer(next);
				}
				next = L(n);
				if(!visited[next]) {
					visited[next] = true;
					command[next] = command[n]+"L";
					q.offer(next);
				}
				next = R(n);
				if(!visited[next]) {
					visited[next] = true;
					command[next] = command[n]+"R";
					q.offer(next);
				}
			}
		}
	}
	
	public static int D(int value) {
		return (2 * value) % MAX;
	}
	public static int S(int value) {
		if(value == 0) return 9999;
		return value - 1;
	}
	public static int L(int value) {
		sb = new StringBuilder(String.valueOf(value));
		if(sb.length() == 1) sb.insert(0, "000");
		else if(sb.length() == 2) sb.insert(0, "00");
		else if(sb.length() == 3) sb.insert(0, "0");
		
		char tmp = ' ';
		char next = ' ';
		for(int i = 3; i >= 0 ; i--) {
			if(i == 3) {
				next = sb.charAt(i);
				sb.setCharAt(i, sb.charAt(0));
			}
			else {
				tmp = sb.charAt(i);
				sb.setCharAt(i, next);
				next = tmp;
			}
		}
		
		return Integer.parseInt(sb.toString());
	}
	public static int R(int value) {
		sb = new StringBuilder(String.valueOf(value));
		if(sb.length() == 1) sb.insert(0, "000");
		else if(sb.length() == 2) sb.insert(0, "00");
		else if(sb.length() == 3) sb.insert(0, "0");
		
		char tmp = ' ';
		char next = ' ';
		for(int i = 0; i < 4 ; i++) {
			if(i == 0) {
				next = sb.charAt(i);
				sb.setCharAt(i, sb.charAt(3));
			}
			else {
				tmp = sb.charAt(i);
				sb.setCharAt(i, next);
				next = tmp;
			}
		}
		
		return Integer.parseInt(sb.toString());
	}
}
