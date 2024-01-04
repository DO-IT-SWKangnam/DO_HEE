import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9466 {
	static int count;
	static int arr[];
	static boolean visited[], done[];
	
	public static void dfs(int idx) {
		if(done[idx]) return; // ������ �̹� �˻��ߴٴ� ���̹Ƿ� �� �̻� �� �ʿ䰡 ����.
		if(visited[idx]) { // �湮�� �߾��� == ����Ŭ �������̴�
			done[idx] = true; // ���� �ٽ� �� �� �����Ƿ� done üũ
			count++; // ����Ŭ �������̹Ƿ� + 1
		}
		visited[idx] = true; // �湮 üũ
		dfs(arr[idx]);
		done[idx] = true; // ����Ŭ�� �ƴ� �ֵ鵵 �˻� �������ϱ� done üũ
		visited[idx] = false; // �湮 üũ�� �� �ʱ�ȭ
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			count = 0;
			arr = new int[n + 1];
			done = new boolean[n + 1]; 
			visited = new boolean[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 1; i <= n; i++) {
				if(done[i]) continue; // �̹� �˻��� �ֵ��� ��ŵ�Ѵ�.
				dfs(i);
			}
			System.out.println(n - count); // ����Ŭ�� �ش����� �ʴ� �л� �� ���
		}
	}
	}