import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1963 {
	static boolean prime[];
	static boolean visited[];
	static int count[];
	
	public static int change(int num, int i, int j) {
        StringBuilder sb = new StringBuilder(String.valueOf(num)); 
        sb.setCharAt(i, (char) (j + '0')); 
        return Integer.parseInt(sb.toString()); 
    }
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		 prime = new boolean[10000];
	     prime[0] = prime[1] = true;
	     for (int i = 2; i < 10000; i++) {
	         if (!prime[i]) {
	             for (int j = i * i; j < 10000; j += i) {
	                 prime[j] = true;
	             }
	         }
	     }   
		
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			Queue<Integer> q = new LinkedList<>();
			boolean possible = false;
			count = new int [10000];
			visited = new boolean[10000];
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			q.offer(A);
			visited[A] = true;
			count[A] = 0;
			while(!q.isEmpty()) {
				int n = q.poll();
				if(n == B) {
					possible = true;
					System.out.println(count[B]);
					break;
				}
				for(int i = 0; i <4; i++) {
					for(int j = 0; j < 10 ; j++) {
						if(i == 0 && j ==0) continue;
						int next = change(n, i , j);
						if(!visited[next] && !prime[next]) {
							visited[next] = true;
							q.offer(next);
							count[next] = count[n] + 1;
						}
					}
				}
			}
			
			if(!possible) System.out.println("Impossible");
		}
	}
}
