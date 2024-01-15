import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_1167 {
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
		
		for(int i = 0; i < size ; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			while(true) {
				int num2 = Integer.parseInt(st.nextToken());
				if(num2 == -1) break;
				int value = Integer.parseInt(st.nextToken());
				
				tree[num1].add(new Node(num2, value));			
			}
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
			}
		}
	}
}

/* 1번 노드의 정점이 두 개 이상인 경우를 반대편 정점에서 탐색을 하는 것으로 풂(구글링) */