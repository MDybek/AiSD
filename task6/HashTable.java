package com.company;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class HashTable{
	LinkedList arr[]; // use pure array
	private final static int defaultInitSize=8;
	private final static double defaultMaxLoadFactor=0.7;
	private int size;
	private final double maxLoadFactor;

	public HashTable() {
		this(defaultInitSize);
	}
	public HashTable(int size) {
		this(size,defaultMaxLoadFactor);
	}


	public HashTable(int initCapacity, double maxLF) {
		//TODO
		this.maxLoadFactor = maxLF;
		this.arr = new LinkedList[initCapacity];
		Arrays.setAll(arr, i -> new LinkedList<>());
	}

	public boolean add(Object elem) {
		//TODO
		if (elem == null)
			return false;
		this.arr[elem.hashCode()% arr.length].add(elem);
		size+=1;

		if ((float)this.size /(float)this.arr.length > this.maxLoadFactor)
			doubleArray();

		return true;
	}


	private void doubleArray() {
		//TODO
		LinkedList newLinkedList [] = new LinkedList[this.arr.length*2];
		Arrays.setAll(newLinkedList, i -> new LinkedList<>());

		for (LinkedList linkedList : this.arr) {
			for (Object o : linkedList)
				newLinkedList[o.hashCode() % newLinkedList.length].add(o);
		}
		this.arr = newLinkedList;
	}


	@Override
	public String toString() {
		//TODO
		// use	IWithName x=(IWithName)elem;
		int size;
		String toStr = "";
		for(int i = 0; i < this.arr.length; i++){
			toStr += i + ":";
			size = this.arr[i].size();
			if(size!=0){
				toStr += " ";
				for(int j = 0; j < size-1; j++){
					IWithName x = (IWithName) this.arr[i].get(j);
					toStr += x.getName() + ", ";
				}
				IWithName x = (IWithName) this.arr[i].get(size-1);
				toStr += x.getName();
			}
			toStr += "\n";
		}

		return toStr;
	}

	public Object get(Object toFind) {
		//TODO
		int index = toFind.hashCode()%this.arr.length;
		int indexToFind = this.arr[index].indexOf(toFind);
		if(indexToFind != -1){
			return this.arr[index].get(indexToFind);
		}
		return null;
	}

}

