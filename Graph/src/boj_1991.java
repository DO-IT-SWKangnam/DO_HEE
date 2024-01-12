import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1991 {
	static class Node{
		char value;
		Node left;
		Node right;
		
		Node(char value, Node left, Node right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	static Node head = new Node('A', null, null);
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int size = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i< size ; i++) {
			String str = br.readLine();
			
			char value = str.charAt(0);
			char left = str.charAt(2);
			char right = str.charAt(4);
			
			createNode(head, value, left, right);
		}
		
		preOrder(head);
		System.out.println();
		inOrder(head);
		System.out.println();
		postOrder(head);
	}
	
	public static void createNode(Node temp, char value, char left, char right) {
		if(temp.value == value) { //value가 가리키는 노드가 맞다면
			if(left != '.') temp.left = new Node(left, null, null);
			if(right != '.') temp.right = new Node(right, null, null);
		}
		else {
			if(temp.left != null) createNode(temp.left, value, left, right);
			if(temp.right != null) createNode(temp.right, value, left, right);
		}
	}
	
	public static void preOrder(Node temp) {
		System.out.print(temp.value);
		if(temp.left != null) preOrder(temp.left);
		if(temp.right != null) preOrder(temp.right);
	}
	
	public static void inOrder(Node temp) {
		if(temp.left != null) inOrder(temp.left);
		System.out.print(temp.value);
		if(temp.right != null) inOrder(temp.right);
	}
	
	public static void postOrder(Node temp) {
		if(temp.left != null) postOrder(temp.left);
		if(temp.right != null) postOrder(temp.right);
		System.out.print(temp.value);
	}
}
