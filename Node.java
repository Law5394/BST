package BST;
/**
 * @author James Law
 *
 */
public class Node<Key extends Comparable<Key>> {
	private Key value;
	private Node<Key> leftChild;
	private Node<Key> rightChild;

	// constructor
	Node(Key value) {
		this.value = value;
	}

	// key value getter
	public Key getValue() {
		return value;
	}

	// key value setter
	public void setValue(Key value) {
		this.value = value;
	}

	// left child getter
	public Node<Key> getLeftChild() {
		return leftChild;
	}

	// left child setter
	public void setLeftChild(Node<Key> leftChild) {
		this.leftChild = leftChild;
	}

	// right child getter
	public Node<Key> getRightChild() {
		return rightChild;
	}

	// right child setter
	public void setRightChild(Node<Key> rightChild) {
		this.rightChild = rightChild;
	}

	// to string
	public String toString() {
			return (value.toString());
	}

}

