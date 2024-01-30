import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1517 {
	static long arr[];
	static long tmp[];
	static long count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new long[N];
		tmp = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		count = 0l;
		
		mergeSort(0, N - 1);
		
		System.out.print(count);
	}
	
	static void mergeSort(int left, int right) {
		if(left >= right) return;
		
		int mid = (left + right) /2;
		
		mergeSort(left , mid);
		mergeSort(mid+1, right);
		
		merge(left, mid, right);
	}
	
	static void merge(int left,int mid, int right ) {
		int lp = left;
		int rp = mid+1;
		int idx = lp;
		
		 while(lp <= mid && rp <= right) {
	            if(arr[lp] <= arr[rp])
	                tmp[idx++] = arr[lp++];
	            else {
	            	tmp[idx++] = arr[rp++];
	                count += (mid + 1 - lp);
	            }
	        }
	 
	        while(lp <= mid) 
	        	tmp[idx++] = arr[lp++];
	        
	        while(rp <= right)
	        	tmp[idx++] = arr[rp++];

	    
		
		for(int i=left; i<=right; i++) {
			arr[i] = tmp[i];
		}
	}
}
