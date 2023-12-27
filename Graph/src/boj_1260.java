import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1260 {
	static class Graph {
		int vertex;
		LinkedList<Integer> DFSlist[];
		LinkedList<Integer> BFSlist[];
		
		public Graph(int v) {
			vertex = v +1;
			DFSlist = new LinkedList[vertex];
			BFSlist = new LinkedList[vertex];
			for(int i = 0; i<vertex; i++) {
				DFSlist[i] = new LinkedList();
				BFSlist[i] = new LinkedList();
			}
		}
		
		public void addEdge(int a, int b) {
			DFSlist[a].addFirst(b);
			DFSlist[b].addFirst(a);
			BFSlist[a].add(b);
			BFSlist[b].add(a);
			
			Collections.sort(DFSlist[a], (o1, o2) -> o2 - o1);
			Collections.sort(DFSlist[b], (o1, o2) -> o2 - o1);
			Collections.sort(BFSlist[a]);
			Collections.sort(BFSlist[b]);
		}
		
		public void DFS(int start) {
			boolean visited[] = new boolean[vertex];
			Stack<Integer> stack = new Stack<>();
			
			stack.push(start);
			
			while(!stack.isEmpty()) {
				int n = stack.pop();
				if(!visited[n]) {
					visited[n]=true;
					System.out.print(n + " ");
					for(int next: DFSlist[n]) {
						if(!visited[next]) {
							stack.push(next);
						}
					}
				}
			}
			System.out.println();
		}
		
		public void BFS(int start) {
			boolean visited[] = new boolean[vertex];
			Queue<Integer> queue = new LinkedList<>();
			
			queue.offer(start);
			visited[start]=true;
			while(!queue.isEmpty()) {
				int n = queue.poll();
				System.out.print(n + " ");
				
				for(int next: BFSlist[n]) {
					if(!visited[next]) {
						queue.offer(next);
						visited[next]=true;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		Graph graph = new Graph(N);
		for(int i = 0; i < M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			graph.addEdge(a, b);
		}
		
		graph.DFS(V);
		graph.BFS(V);
	}
}

/* 순서가 보장되지 않은 경우 정렬 필요 */
