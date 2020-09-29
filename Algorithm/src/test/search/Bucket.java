package test.search;

import test.enums.OpenHashStatus;

public class Bucket<K, V> {
	
	private K key;
	private V value;
	private OpenHashStatus status;
	
	public Bucket() {
		this.status = OpenHashStatus.EMPTY;
	}
	
	public void set(K key, V value, OpenHashStatus status) {
		this.key = key;
		this.value = value;
		this.status = status;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public OpenHashStatus getStatus() {
		return status;
	}

	public void setStatus(OpenHashStatus status) {
		this.status = status;
	}
}
