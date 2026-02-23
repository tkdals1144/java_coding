package tree;
import java.util.*;
import java.io.*;
class Node {
	public char value;
	public Node left;
	public Node right;
	public Node(char value) {
		super();
		this.value = value;
	}
}
public class B1991 {
	static int N;
	static Map<Character, Node> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	static void preorder(Node node) {
		sb.append(node.value);
		if (node.left != null) {
			preorder(node.left);
		}
		if (node.right != null) {
			preorder(node.right);
		}
	}
	static void inorder(Node node) {
		if (node.left != null) {
			inorder(node.left);
		}
		sb.append(node.value);
		if (node.right != null) {
			inorder(node.right);
		}
	}
	static void postorder(Node node) {
		if (node.left != null) {
			postorder(node.left);
		}
		if (node.right != null) {
			postorder(node.right);
		}
		sb.append(node.value);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c1 = st.nextToken().charAt(0);
			char c2 = st.nextToken().charAt(0);
			char c3 = st.nextToken().charAt(0);
			
			map.putIfAbsent(c1, new Node(c1));
			
			if (c2 != '.') {
				map.putIfAbsent(c2, new Node(c2));
				map.get(c1).left = map.get(c2);
			}
			if (c3 != '.') {
				map.putIfAbsent(c3, new Node(c3));
				map.get(c1).right = map.get(c3);
			}
		}
		Node root = map.get('A');
		preorder(root);
		sb.append('\n');
		inorder(root);
		sb.append('\n');
		postorder(root);
		System.out.println(sb.toString());
	}
}
