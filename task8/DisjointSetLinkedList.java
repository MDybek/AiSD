package dsaa.lab09;

public class DisjointSetLinkedList implements DisjointSetDataStructure {

	private class Element{
		int representant;
		int next;
		int length;
		int last;
	}
	
	private static final int NULL=-1;
	
	Element arr[];
	
	public DisjointSetLinkedList(int size) {
		//TODO
		arr = new Element[size];
		for (int i = 0; i<size; i++)
			makeSet(i);
	}
	
	@Override
	public void makeSet(int item) {
		//TODO
		arr[item] = new Element();
		arr[item].representant = item;
		arr[item].next = -1;
		arr[item].length = 1;
		arr[item].last = item;
	}

	@Override
	public int findSet(int item) {
		//TODO
		if (item < 0 || item > arr.length)
			return -1;
		int searching = arr[item].representant;
		return searching;
	}

	@Override
	public boolean union(int itemA, int itemB) {
		//TODO
		if (findSet(itemA) == -1 || findSet(itemB) == -1)
			return false;
		if (findSet(itemA) == findSet(itemB))
			return false;
		Element rep1 = arr[findSet(itemA)];
		Element rep2 = arr[findSet(itemB)];
		if (rep1.length < rep2.length){
			swap(rep1, rep2);
		}
		arr[rep1.last].next = rep2.representant;
		rep1.last = rep2.last;
		rep1.length = rep1.length+ rep2.length;
		Element actelem = rep2;
		for(int i = 0; i < rep2.length; i++){
			actelem.representant = rep1.representant;
			if(actelem.next!=NULL)actelem = arr[actelem.next];
		}
		return true;
	}

	public void swap(Element el1, Element el2){
		Element temp = el1;
		el1 = el2;
		el2 = temp;
	}

	@Override
	public String toString() {
		//TODO
		String tostr = "Disjoint sets as linked list:\n";
		if (arr.length == 0)
			return tostr.substring(0, tostr.length()-1);
		for (int i =0; i< arr.length;i++){
			if (arr[i].representant == i){
				int temp = i;
				while (temp != -1){
					tostr += temp;
					if (arr[temp].next != -1)
						tostr += ", ";
					temp = arr[temp].next;
				}
				tostr += "\n";
			}
		}
		tostr = tostr.substring(0, tostr.length()-1);
		return tostr;
	}

    @Override
    public int countSets() {
        // TODO
        return -1;
    }
}
