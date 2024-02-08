import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1697 {
	static int N, K;
	static int MAX = 100001;
	static int count[] = new int[MAX];
	static boolean visited[] = new boolean[MAX];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		BFS(N);
		
		System.out.print(count[K]);
	}
	
	public static void BFS(int value) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(value);
		visited[value] = true;
		count[value] = 0;
		
		while(!q.isEmpty()) {
			int n = q.poll();
			
			if(n == K) return;
			
			int next = n * 2;
			if(next < MAX && !visited[next]) {
				q.offer(next);
				count[next] = count[n]+1;
				visited[next] = true;
			}
			next = n - 1;
			if(next >= 0 && !visited[next]) {
				q.offer(next);
				count[next] = count[n]+1;
				visited[next] = true;
			}
			next = n + 1;
			if(next < MAX && !visited[next]) {
				q.offer(next);
				count[next] = count[n]+1;
				visited[next] = true;
			}
		}
	};
}
