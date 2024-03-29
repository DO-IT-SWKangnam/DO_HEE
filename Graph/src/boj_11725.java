import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11725 {
	static int size;
	static LinkedList<Integer> nodes[];
	static int[] parent; 
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		size = Integer.parseInt(br.readLine());
		
		nodes= new LinkedList[size+1];
		parent = new int[size+1];
		for (int i = 1; i <size+1 ; i++) {
            nodes[i] = new LinkedList<>();
        }
		
		for (int i = 0; i <size-1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			nodes[a].add(b);
			nodes[b].add(a);
		}
		
		findParent();
		
		for (int i = 2; i <=size ; i++) {
			System.out.println(parent[i]);
		}
	}
	
	public static void findParent() {
		Queue<Integer> queue  = new LinkedList<>();
		boolean visited[] = new boolean[size+1];
		
		queue.offer(1);
		visited[1] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : nodes[now]) {
				if(!visited[next]) {
					queue.offer(next);
					visited[next] = true;
					parent[next] = now;
				}
			}
		}
	}
}

/* 굳이 매 번 할 필요가 없었움.. */