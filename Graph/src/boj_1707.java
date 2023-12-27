import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj_1707 {
	static int color[];
	static class Graph {
		int vertex;
		LinkedList<Integer> list[];
		
		
		public Graph(int v) {
			vertex = v + 1;
			list = new LinkedList[vertex];
			color = new int[vertex];
			for(int i = 1 ; i < vertex; i++) {
				list[i] = new LinkedList();
			}
		}
		
		public void addEdge(int a, int b) {
			list[a].add(b);
			list[b].add(a);
		}
		
		public boolean BFS(int start) {
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(start);
			color[start] = 2;
			while(!queue.isEmpty()) {
				int n = queue.poll();
				for(int next: list[n]) {
					if(color[next]==color[n]) {
						return false;
					}
					else if(color[next]==0) {
						queue.offer(next);
						color[next]= color[n]*-1;
					}
					
				}
			}
			return true;
		}
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int j = 0; j < tc; j++) {
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
			
			boolean result = false;
			 for(int vertex = 1; vertex <= N; vertex++) {
	                if(color[vertex] == 0) {
	                	result = graph.BFS(vertex);
	                }
	                if(!result) break;
	         }
			 
			if(result)System.out.println("YES");
			else System.out.println("NO");
		}
	}
}

/* »ðÁú ¤©¤¸¤§ ¤µ¤²*/
