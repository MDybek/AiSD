package dsaa.lab08;

import java.util.Scanner;

public class Document implements IWithName{
	public String name;
	public BST<Link> link;
	public Document(String name) {
		this.name=name.toLowerCase();
		link=new BST<Link>();
	}

	public Document(String name, Scanner scan) {
		this.name=name.toLowerCase();
		link=new BST<Link>();
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
		String retStr="Document: "+name+"\n";
		retStr+=link.toStringInOrder();		
		return retStr;
	}

	public String toStringPreOrder() {
		String retStr="Document: "+name+"\n";
		retStr+=link.toStringPreOrder();
		return retStr;
	}

	public String toStringPostOrder() {
		String retStr="Document: "+name+"\n";
		retStr+=link.toStringPostOrder();
		return retStr;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public String getName() {
		return name;
	}
}
