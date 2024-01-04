import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2331 {
	static class Graph{
		int vertex;
		LinkedList<Integer> list[];
		
		public Graph(int v) {
			vertex = v + 1;
			list = new LinkedList[vertex];
			for(int i = 0;i<vertex; i++) {
				list[i] = new LinkedList();
			}
		}
		
		public void addEdge(int a, int b) {
			list[a].add(b);
			list[b].add(a);
		}
		
		public boolean findCycle(int start) {
			if(list[start].size() > 2) {
				return false;
			}
			else return true;
		}
		
		public int BFS(int start, int end) {
			Queue<Integer> queue = new LinkedList<>();
			boolean visited[] = new boolean[vertex];

			queue.offer(start);
			visited[start] = true;
			int count = 0;
			
			while(!queue.isEmpty()) {
				int n = queue.poll();
				if(n == end) {
					return count;
				}
				count++;
				for(int next: list[n]) {
					if(!visited[next]) {
						queue.offer(next);	
						visited[next] = true;
					}
				}
			}
			return count;
		}
	}
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int value = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		Graph g = new Graph(1000002);
		int before = value;
		while(true) {
			String str = before + "";
			int sum = 0;
			for(int i = 0; i < str.length() ; i++) {
				int num = str.charAt(i) - '0';
				sum += Math.pow(num, n);
			}
			g.addEdge(before, sum);
			
			if(!g.findCycle(sum)) {
				if(before == value) System.out.print(0);
				else System.out.print(g.BFS(value, sum));
				break;
			}
			before = sum;
		}
	}
}
