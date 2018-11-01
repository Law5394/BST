package BST;


/**
 * @author James Law
 *
 */
public class BinarySearchTree<Key extends Comparable<Key>> {
	// root node of the BST
	Node<Key> root;

	// returns true if k is in the BST. false if not.
	public boolean contains(Key k) {
		Node<Key> searchNode = root;
		while (searchNode != null) {
			
			// checks to see if k is less than current node value if yes it goes to left child
			if (k.compareTo(searchNode.getValue()) == -1) 
				searchNode = searchNode.getLeftChild();
			
			// checks to see if k is greater than current node value if yes goes to right child
			else if (k.compareTo(searchNode.getValue()) == 1) 
				searchNode = searchNode.getRightChild();
			// if the value does not get to null then the k must match the vlaue of the current node 
			else
				return true;
		}
		
		return false;
	}

	// if tree is empty inserts node else it calls insert with root as a parameter
	public void insert(Key k) {
		if (root == null)
			root = new Node<Key>(k);
		else
			insert(root, k);
	}

	// recursively inserts node
	private Node<Key> insert(Node<Key> node, Key k) {

		// base case
		if (node == null)
			return new Node<Key>(k);

		// node to be inserted is less than current node
		else if (k.compareTo(node.getValue()) == -1)
			node.setLeftChild(insert(node.getLeftChild(), k));
		// node to be inserted is greater than current node
		else
			node.setRightChild(insert(node.getRightChild(), k));
		
		return node;
	}
	
	
	// calls delete with the root as the parameter
		public void delete(Key k) {
			delete(root, k);
		}

		// recursively deletes the node with key k
		private Node<Key> delete(Node<Key> node, Key k) {
			// base case
			if (node == null)
				return node;
			// node to be deleted is less than current node
			else if (k.compareTo(node.getValue()) == -1)
				node.setLeftChild(delete(node.getLeftChild(), k));
			// node to be deleted is greater than current node
			else if (k.compareTo(node.getValue()) == 1)
				node.setRightChild(delete(node.getRightChild(), k));
			// node to be deleted is current node
			else {
				// if it has no left child replaces itself with right child
				if (node.getLeftChild() == null)
					return node.getRightChild();
				// if it has no right child replaces itself with left child
				else if (node.getRightChild() == null)
					return node.getLeftChild();
				/*
				 *  else it has two nodes so it has to replace itself with the smallest node in right subtree list
				 */
				
				else {
					Node<Key> successor = node.getRightChild();
					Key value = successor.getValue();
					while (successor.getLeftChild() != null) {

						successor = successor.getLeftChild();
						value = successor.getValue();
					}
					delete(root, value);
					node.setValue(value);
				}
			}
			return node;
		}

	// prints a well formatted in order visit of every node in the BST.
	public void inorder() {
		inorder(root);

	}

	// recursive in order traversal 
	private void inorder(Node<Key> searchNode) {
		if (searchNode != null) {
			inorder(searchNode.getLeftChild());
			System.out.println(searchNode.toString());
			inorder(searchNode.getRightChild());
		}

	}

	// prints a well formatted pre order visit of every node in the BST.
	public void preorder() {
		preorder(root);
	}

	// recursive pre order traversal
	private void preorder(Node<Key> searchNode) {
		if (searchNode != null) {
			System.out.println(searchNode.toString());

			preorder(searchNode.getLeftChild());
			preorder(searchNode.getRightChild());
		}
	}

	// prints a well formatted post order visit of every node in the BST.
	public void postorder() {
		postorder(root);
	}

	// recursive post order traversal
	private void postorder(Node<Key> searchNode) {
		if (searchNode != null) {
			postorder(searchNode.getLeftChild());
			postorder(searchNode.getRightChild());
			System.out.println(searchNode);
		}
	}


}
