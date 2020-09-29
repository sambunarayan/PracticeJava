package test.search;

import test.enums.OpenHashStatus;

public class OpenHash<K, V> {
	
	private Bucket<K, V>[] buckets;
	private int capacity = 13;
	private int size = 0;
	
	public OpenHash() {
		buckets = new Bucket[capacity];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Bucket<>();
		}
	}
	
	public OpenHash(int capacity) {
		buckets = new Bucket[capacity];
		this.capacity = capacity;
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Bucket<>();
		}
	}
	
	public Bucket<K, V> getNode(K key) {
		int hash = hashCode(key);
		Bucket<K, V> bucket = buckets[hash];
		if (bucket.getStatus() == OpenHashStatus.EMPTY) {
			return null;
		}
		for (int i = 0; i < capacity && bucket.getStatus() != OpenHashStatus.EMPTY; i++) {
			hash = reHash(hash);
			bucket = buckets[hash];
			if (bucket.getStatus() == OpenHashStatus.OCCUPIED && bucket.getKey().equals(key)) {
				return bucket;
			}
		}
		return null;
	}
	
	public boolean add(K key, V value) {
		if (size == capacity) {
			System.out.println("Buckets is full");
			return false;
		}
		if (getNode(key) != null) {
			System.out.println("Already exist key");
			return false;
		}
		int hash = hashCode(key);
		for (int i = 0; i < capacity; i++) {
			if (buckets[hash].getStatus() != OpenHashStatus.OCCUPIED) {
				buckets[hash].set(key, value, OpenHashStatus.OCCUPIED);
				size++;
				return true;
			}
			hash = reHash(hash);
		}
		return false;
	}
	
	public boolean remove(K key) {
		if (size == 0) {
			System.out.println("Buckets is empty");
			return false;
		}
		Bucket<K, V> bucket = getNode(key);
		if (bucket == null) {
			System.out.println("Not found key");
			return false;
		} else if (bucket.getStatus() == OpenHashStatus.DELETED) {
			System.out.println("Already removed key");
			return false;
		}
		bucket.setStatus(OpenHashStatus.DELETED);
		size--;
		return true;
	}
	
	public void show() {
		for (int i = 0; i < buckets.length; i++) {
			System.out.print("buckets[" + i + "] ");
			System.out.print("K=" + buckets[i].getKey() + ", ");
			System.out.print("V=" + buckets[i].getValue() + ", ");
			System.out.println("STATUS=" + buckets[i].getStatus() + " ");
		}
	}
	
	private int hashCode(K key) {
		return key.hashCode() % capacity;
	}
	
	private int reHash(int hash) {
		return (hash + 1) % capacity;
	}
}
