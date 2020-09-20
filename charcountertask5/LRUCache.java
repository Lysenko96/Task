package com.lysenko.charcountertask5;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Entry {
	int counter;
	char uniqueChar;
	Entry prevNode;
	Entry nextNode;
}

public class LRUCache {

	Map<Character, Entry> cacheKeys;
	Entry start, end;
	int LRU_SIZE;

	public LRUCache(int cacheSize) {
		cacheKeys = new LinkedHashMap<Character, Entry>();
		this.LRU_SIZE = cacheSize;
	}

	public int getEntry(char uniqueChar) {
		if (cacheKeys.containsKey(uniqueChar)) {
			Entry entry = cacheKeys.get(uniqueChar);
			removeNode(entry);
			addInBegin(entry);
			return entry.counter;
		}
		return -1;
	}

	public void putEntry(char uniqueChar, int counter) {
		if (cacheKeys.containsKey(uniqueChar)) {
			Entry entry = cacheKeys.get(uniqueChar);
			entry.counter = counter;
			removeNode(entry);
			addInBegin(entry);
		} else {
			Entry newEntry = new Entry();
			newEntry.prevNode = null;
			newEntry.nextNode = null;
			newEntry.counter = counter;
			newEntry.uniqueChar = uniqueChar;
			if (cacheKeys.size() > LRU_SIZE) {
				cacheKeys.remove(end.uniqueChar);
				removeNode(end);
				addInBegin(newEntry);
			} else {
				addInBegin(newEntry);
			}
			cacheKeys.put(uniqueChar, newEntry);
		}
	}

	public void addInBegin(Entry node) {
		node.nextNode = start;
		node.prevNode = null;
		if (start != null) {
			start.prevNode = node;
		}
		start = node;
		if (end == null) {
			end = start;
		}
	}

	public void removeNode(Entry node) {
		if (node.prevNode != null) {
			node.prevNode.nextNode = node.nextNode;
		} else {
			start = node.nextNode;
		}
		if (node.nextNode != null) {
			node.nextNode.prevNode = node.prevNode;
		} else {
			end = node.prevNode;
		}
	}

//	public static void main(String[] args) {
//		LRUCache lruCache = new LRUCache();
//		lruCache.putEntry('h', 1);
//		lruCache.putEntry('e', 1);
//		lruCache.putEntry('l', 2);
//		lruCache.putEntry('l', 2);
//		lruCache.putEntry('o', 1);
//
//		List<Character> list = new LinkedList<>(lruCache.cacheKeys.keySet());
//		System.out.println(lruCache.cacheKeys.keySet());
//		for (int index = 0; index < list.size(); index++) {
//			if (lruCache.cacheKeys.containsKey(list.get(index))) {
//				System.out.println(lruCache.getEntry(list.get(index)));
//			}
//		}
//	}
}
