import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_10451 {
	static class Graph{
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
		
		public boolean BFS(int start) {
			if(visited[start] == true) return false;
			Queue<Integer> queue = new LinkedList<>();
			
			queue.offer(start);
			visited[start]=true;
			while(!queue.isEmpty()) {
				int n = queue.poll();
				
				for(int next: list[n]) {
					if(!visited[next]) {
						queue.offer(next);
						visited[next]=true;
					}
				}
			}
			return true;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < tc ; tc++) {
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j <n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Graph g = new Graph(n);
			for(int j = 0; j < n ; j++) {
				g.addEdge(arr[j], j+1);
			}
				
			int count = 0;
			for(int j = 1; j < n + 1 ; j++) {
				if(g.BFS(j)) count++;
			}
			
			System.out.println(count);
		}
	}
}

