import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String arr[][] = new String[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken()+"";
			arr[i][1] = st.nextToken();
		}
		
		Arrays.sort(arr, (a1, a2)-> {
			return Integer.parseInt(a1[0])-Integer.parseInt(a2[0]);
		});
	
		for(int i=0; i<n; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
		}
		
		System.out.println(sb);
	}
}

/* Line 18���� ����ȯ�� �Ͼ [][1]�� �Է��� �� ������ ����
 * �׷��� +"" �߰�*/
 