import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_1967 {
	static int size, node;
	static int max = 0;
	static LinkedList<Node> tree[];
	static boolean[] visited;
	
	public static class Node {
		int node;
		int value;
		
		public Node(int node, int value) {
			this.node = node;
			this.value = value;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		size = Integer.parseInt(br.readLine());
		tree = new LinkedList[size+1];
		visited = new boolean[size+1];
		for(int i = 1; i <= size ; i++) {
			tree[i]= new LinkedList<Node>();
		}
		
		if(size == 1) {
			System.out.print(0);
			return;
		}
		
		for(int i = 0; i < size -1  ; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
				
			tree[num1].add(new Node(num2, value));
			tree[num2].add(new Node(num1, value));
		}
		
		DFS(1, 0);
		
		visited = new boolean[size + 1];
        DFS(node, 0);
		
		System.out.println(max);
	}
	
	static void DFS(int now, int len) {
		if(len > max) {
	        max = len;
            node = now;
	    }
		
		visited[now] = true;
		
		for(Node next: tree[now]) {
			if(!visited[next.node]) {
				DFS(next.node, next.value + len);
				visited[next.node] = true;
			}
		}
	}
}
