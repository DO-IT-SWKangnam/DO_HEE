import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11728 {
	static int a[], b[], merge[], temp[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		a = new int[Integer.parseInt(st.nextToken())];
		b = new int[Integer.parseInt(st.nextToken())];
		merge = new int[a.length+b.length];
		temp = new int[merge.length];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < b.length; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		System.arraycopy(a, 0, merge, 0, a.length);
		System.arraycopy(b, 0, merge, a.length, b.length);
		
		mergeSort(0, merge.length-1);
		
		for(int i = 0; i < merge.length; i++) {
			sb.append(merge[i]).append(' ');
		}
		System.out.print(sb);
	}
	
	static void mergeSort(int left, int right) {
		if(left >= right) return;
		
		int mid = (left + right ) / 2;
		mergeSort(left, mid);
		mergeSort(mid + 1 , right);
		
		merge(left, mid, right);
	}
	
	static void merge(int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int idx = l;
		
		while(l <= mid || r <= right) {
			if(r > right || (l <= mid && merge[l]< merge[r])) {
				temp[idx++] = merge[l++];
			}
			else {
				temp[idx++] = merge[r++];
			}
		}
		
		for(int i = left; i <=right ;i++) {
			merge[i] = temp[i];
		}
	}
}
