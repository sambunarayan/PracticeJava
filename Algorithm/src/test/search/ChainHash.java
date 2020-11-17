package test.search;

public class ChainHash<K, V> {
	private Node<K, V>[] nodes;
	private int size;
	
	public ChainHash(int size) {
		try {
			nodes = new Node[size];
			this.size = size;
		} catch (OutOfMemoryError e) {
			this.size = 0;
		}
	}
	
	public Node<K, V> search(K k) {
		if (isEmpty()) {
			return null;
		}
		int key = hashValue(k);
		Node<K, V> node = nodes[key];
		while (node != null) {
			if (node.getKey().equals(k)) {
				return node;
			}
			node = node.next();
		}
		return null;
	}
	
	public boolean add(K k, V v) {
		int key = hashValue(k);
		if (search(k) != null) {
			return false;
		}
		Node<K, V> temp = new Node<K, V>(k, v, nodes[key]);
		nodes[key] = temp;
		size++;
		return true;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private int hashValue(K k) {
		return k.hashCode() / size;
	}
}
