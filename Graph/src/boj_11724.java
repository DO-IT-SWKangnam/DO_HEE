import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj_11724 {
	static class Graph {
		int vertex;
		LinkedList<Integer> list[];
		boolean visited[];
		
		public Graph(int v) {
			vertex = v + 1;
			list = new LinkedList[vertex];
			visited = new boolean[vertex];
			for(int i = 1 ; i < vertex; i++) {
				list[i] = new LinkedList();
			}
		}
		
		public void addEdge(int a, int b) {
			list[a].add(b);
			list[b].add(a);
		}
		
		public int BFS(int start) {
			if(visited[start]) return 0;
			Queue<Integer> queue = new LinkedList<>();
			
			queue.offer(start);
			visited[start] = true;
			while(!queue.isEmpty()) {
				int n = queue.poll();
				for(int next: list[n]) {
					if(!visited[next]) {
						queue.offer(next);
						visited[next] = true;
					}
				}
			}
			return 1;
		}
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Graph graph = new Graph(N);
		for(int i = 0; i < M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			graph.addEdge(a, b);
		}
		
		int count = 0;
		for(int i = 1; i < N + 1; i++) {
			count += graph.BFS(i);
		}
		System.out.print(count);
	}
}
