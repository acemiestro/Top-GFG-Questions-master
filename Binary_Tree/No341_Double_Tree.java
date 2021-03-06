package Binary_Tree;


import java.util.Stack;

public class No341_Double_Tree {

	class Node {
		Node left;
		Node right;
		int data;

	}

	static Node root;
	static int size = 0;

	public No341_Double_Tree(int[] arr) {
		Stack<Node> stack = new Stack<No341_Double_Tree.Node>();

		for (int val : arr) {

			if (val == -1) {
				stack.pop();
			} else {
				Node node = new Node();
				node.data = val;

				size++;

				if (stack.size() == 0) {
					root = node;
				}

				if (stack.size() > 0) {
					if (stack.peek().left == null) {
						stack.peek().left = node;

					} else {
						stack.peek().right = node;
					}
				}

				stack.push(node);
			}

		}
	}

	public void display() {

		display(root);

	}

	private void display(Node node) {

		if (node == null) {
			return;
		}
		String str = new String();

		str += node.left != null ? node.left.data : ".";

		str += "<- " + node.data + " -> ";

		str += node.right != null ? node.right.data : ".";

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public void DT() {

		DT(root);

	}

	private void DT(Node node) {

		Node oldleft;

		if (node == null) {
			return;
		}

		DT(node.left);
		DT(node.right);

		oldleft = node.left;

		node.left = new Node();
		node.left.data = node.data;

		node.left.left = oldleft;

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No341_Double_Tree bt = new No341_Double_Tree(arr);

		bt.display();

		System.out.println();

		bt.DT();

		System.out.println();

		bt.display();

	}

}
