package com.company;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Scanner;

public class Document implements IWithName{
	public String name;
	public TwoWayCycledOrderedListWithSentinel<Link> link;
	public Document(String name) {
		//TODO
		this.name=name.toLowerCase();
	}

	public Document(String name, Scanner scan) {
		this.name=name.toLowerCase();
		link=new TwoWayCycledOrderedListWithSentinel<Link>();
		load(scan);
	}
	public void load(Scanner scan) {
		//TODO
		String line = scan.nextLine();
		while (!line.equals("eod")) {

			String[] words = line.split("\\s");
			for(String w:words) {

				if(w.length() >5){

					if(w.substring(0,5).toLowerCase().equals("link=") && isCorrectId(w.substring(5))){

						int charindex1 = w.indexOf("(")+1;
						int charindex2 = w.indexOf(")");

						if (charindex1 !=0 && charindex2!= -1) {
							int temp = Integer.parseInt(w.substring(charindex1, charindex2));
							link.add(new Link(w.substring(5,charindex1-1).toLowerCase(), temp));
						}
						else
							link.add(new Link(w.substring(5).toLowerCase()));

					}
				}
			}
			line = scan.nextLine();
		}
	}
	
	// accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
	

	public static boolean isCorrectId(String id) {
		//TODO
		Boolean flag = Character.isLetter(id.charAt(0));
		int charindex1 = id.indexOf("(")+1;
		int charindex2 = id.indexOf(")");
		if ((charindex1 !=0 && charindex2 == -1) || (charindex1 == 0 && charindex2 != -1))
			return false;
		if (charindex1 !=0 && charindex2 != -1) {
			try {
				int num = Integer.parseInt(id.substring(charindex1, charindex2));
				if ( num <= 0)
					return false;
				return true;
			}
			catch (NumberFormatException e) {
				return false;
			}
		}
		else
			return flag;
	}

	// accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
	public static Link createLink(String link) {
		//TODO
		Boolean flag = Character.isLetter(link.charAt(0));
		int charindex1 = link.indexOf("(")+1;
		int charindex2 = link.indexOf(")");
		if ((charindex1 !=0 && charindex2 == -1) || (charindex1 == 0 && charindex2 != -1))
			return null;
		if (charindex1 !=0 && charindex2 != -1) {
			try {
				int num = Integer.parseInt(link.substring(charindex1, charindex2));
				if ( num <= 0)
					return null;
				return new Link(link.substring(0,charindex1-1).toLowerCase(), num);
			}
			catch (NumberFormatException e) {
				return null;
			}
		}
		else
			return new Link(link);
	}

	@Override
	public String toString() {
		String docToStr="Document: "+name;
		//TODO
		for(int i = 0; i < link.size(); i++) {
			if (i==link.size()-1 && link.size()>1){
				docToStr += link.get(i).toString();
			}
			else {
				if (i % 10 == 0 && link.size()==1)
					docToStr += "\n" + link.get(i).toString();
				else{
					if (i % 10 == 0 && link.size()>1)
						docToStr += "\n" + link.get(i).toString() + " ";
					else{
						if (i % 9 == 0)
							docToStr += link.get(i).toString();
						else
							docToStr += link.get(i).toString() + " ";
					}
				}
			}
		}
		return docToStr;
	}

	public String toStringReverse() {
		String retStr="Document: "+name;
		if (!link.isEmpty()) retStr+= "\n";
		ListIterator<Link> iter=link.listIterator();
		while(iter.hasNext())
			iter.next();
		//TODO
		int i = 0;
		while(iter.hasPrevious()){
			if (i%9==0 && i!=0) {
				retStr += iter.previous() + "\n";
			}
			else {
				retStr += iter.previous();
				if(iter.hasPrevious()) retStr += " ";
			}
			i++;
		}
		return retStr;
	}

	@Override
	public String getName() {
		// TODO
		return this.name;
	}

	public int hashCode(){
		int [] sequence = {7,11,13,17,19};
		char [] letters = getName().toCharArray();
		int hashID = letters[0];
		for (int i=1; i< letters.length;i++){
			hashID = hashID * sequence[(i - 1) % sequence.length] + (int) letters[i];
			if(hashID >= 2000000000)
				hashID %= 2000000000;
		}
		return hashID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Document document = (Document) o;
		return name.equals(document.name);
	}

}

