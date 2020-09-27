package test.search;

public class Node<K, V> {
	private K key;
	private V value;
	private Node<K, V> next;
	
	public Node(K key, V value, Node<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public Node<K, V> next() {
		return next;
	}
	
	public int hashCode() {
		return key.hashCode();
	}
	
	@Override
	public String toString() {
		return "["
				+ key + "," + value
				+ "]";
	}
}
