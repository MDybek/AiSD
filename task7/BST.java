package dsaa.lab08;

public class BST<T> {
	private class Node{
		T value;
		Node left;
		Node right;
		Node parent;
		public Node(T v) {
			value=v;
		}
		public Node(T value, Node left, Node right, Node parent) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		private void swap(Node toSwap){
			Node tmp = new Node(this.value, this.left, this.right, this.parent);
			this.value = toSwap.value;
			toSwap.value = tmp.value;
		}
	}

	private Node root = null;
	public String bstString = "";
	public int size = 0;

	public BST() {
	}

	public T getElement(T toFind) {
		// TODO
		if (root == null)
			return null;
		Node searching = getElement(this.root, (Comparable<T>) toFind);
		if (searching == null)
			return null;
		return searching.value;
	}

	private Node getElement(Node root, Comparable<T> toFind){
		if ((root == null) || (toFind.equals(root.value)))
			return root;
		if (toFind.compareTo(root.value) < 0)
			return getElement(root.left, toFind);
		else
			return getElement(root.right, toFind);
	}

	public T successor(T elem) {
		// TODO
		if (root == null)
			return null;
		Node searching = getElement(this.root, (Comparable<T>) elem);
		if (searching == null)
			return null;
		if (searching.right != null)
			return minimum(searching.right).value;
		Node par = searching.parent;
		while(par != null && searching == par.right) {
			searching = par;
			par = par.parent;
		}
		if (par == null)
			return null;
		return par.value;
	}

	private Node minimum(Node val){
		while (val.left != null)
			val = val.left;
		return val;
	}

	public String toStringInOrder() {
		// TODO
		if (root == null)
			return "";
		bstString = "";
		inorder(root);
		if (bstString.length()>0)
			bstString = bstString.substring(0, bstString.length()-2);
		return bstString;
	}

	private void inorder(Node n){
		if (n==null)
			return;
		inorder(n.left);
		bstString += n.value.toString();
		bstString += ", ";
		inorder(n.right);
	}

	public String toStringPreOrder() {
		// TODO
		if (root == null)
			return "";
		bstString = "";
		preorder(root);
		if (bstString.length()>0)
			bstString = bstString.substring(0, bstString.length()-2);
		return bstString;
	}

	private void preorder(Node n){
		if (n==null)
			return;
		bstString += n.value.toString();
		bstString += ", ";
		preorder(n.left);
		preorder(n.right);
	}

	public String toStringPostOrder() {
		// TODO
		if (root == null)
			return "";
		bstString = "";
		postorder(root);
		if (bstString.length()>0)
			bstString = bstString.substring(0, bstString.length()-2);
		return bstString;
	}

	private void postorder(Node n){
		if (n==null)
			return;
		postorder(n.left);
		postorder(n.right);
		bstString += n.value.toString();
		bstString += ", ";
	}

	public boolean add(T elem) {
		// TODO
		Node newElement = new Node(elem);
		if (root == null){
			root = newElement;
			return true;
		}
		Node actNode = root;
		while (true){
			if(((Link) newElement.value).compareTo((Link) actNode.value) >= 0){
				if (actNode.right != null)
					actNode = actNode.right;
				else{
					newElement.parent = actNode;
					actNode.right = newElement;
					return true;
				}
			}
			else{
				if (actNode.left != null)
					actNode = actNode.left;
				else{
					newElement.parent = actNode;
					actNode.left = newElement;
					return true;
				}
			}
		}
	}


	public T remove(T value) {
		// TODO DONE
		Node returned = remove(this.root, value);
		if(returned == null)
			return null;
		return returned.value;
	}

	private Node remove(Node root, T value){
		if (root == null )
			return null;
		Node z = getElement(root, (Comparable<T>) value);
		if(z == null)
			return null;
		Node y;
		if(z.left == null || z.right == null) y = z;
		else y = getElement(root, (Comparable<T>) successor(z.value));
		Node x;
		if(y.left != null)
			x = y.left;
		else
			x = y.right;
		if(x != null)
			x.parent = y.parent;
		if(y.parent == null)
			this.root = x;
		else if(y == y.parent.left)
			y.parent.left = x;
		else
			y.parent.right = x;
		if(y != z)
			y.swap(z);
		return y;
	}

	private void swap(Node a, Node b){
		Node temp = a;
		a = b;
		b = temp;
	}

	public void clear() {
		// TODO
		root = null;
	}

	public int size() {
		// TODO
		size = 0;
		walk(root);
		return size;
	}

	public void walk(Node n){
		if (n==null)
			return;
		size += 1;
		walk(n.left);
		walk(n.right);
	}

	public int twochildren(){
		int num = findtwo(root);
		return num;
	}

	private int findtwo(Node n){
		if (n==null)
			return 0;
		return ((n.left != null && n.right != null)?1:0) + findtwo(n.left) + findtwo(n.right);
	}

}
