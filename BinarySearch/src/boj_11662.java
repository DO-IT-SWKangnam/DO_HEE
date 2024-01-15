import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point{
	public double x, y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
public class boj_11662 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		Point a = new Point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
		Point b = new Point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
		Point c = new Point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
		Point d = new Point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
		
		double start = 0;
		double min = 0, end = 1000000;
		
		while(end- start >= 1e-6) {
			double mid1 = (start * 2 + end) / 3;
			double mid2 = (start + end * 2) / 3;
			
			Point ma1 = new Point(a.x + ((b.x - a.x)*(mid1 / 1000000)), a.y + ((b.y - a.y)*(mid1 / 1000000)));
			Point mc1 = new Point(c.x + ((d.x - c.x)*(mid1 / 1000000)), c.y + ((d.y - c.y)*(mid1 / 1000000)));
			Point ma2 = new Point(a.x + ((b.x - a.x)*(mid2 / 1000000)), a.y + ((b.y - a.y)*(mid2 / 1000000)));
			Point mc2 = new Point(c.x + ((d.x - c.x)*(mid2 / 1000000)), c.y + ((d.y - c.y)*(mid2 / 1000000)));
			
			double fp1 = calc(ma1, mc1);
			double fp2 = calc(ma2, mc2);
			
			if(fp1 > fp2) {
				if(min > fp1) {
					min = fp1;
				}
				start = mid1;
			}
			else {
				if(min > fp1) {
					min = fp1;
				}
				end = mid1;
			}
		}
		
		System.out.print(min);
	}
	
	public static double calc(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p2.y-p1.y, 2)+ Math.pow(p2.x-p1.x,2));
	}
}

/* https://ddamddi.github.io/algorithm/2020/04/21/boj-11662/ */
