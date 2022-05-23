package com.company;


import java.util.ListIterator;
import java.util.Scanner;

public class Document{
    public String name;
    public TwoWayCycledOrderedListWithSentinel<Link> link;
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
    private static Link createLink(String link) {
        //TODO
        return null;
    }

    @Override
    public String toString() {
        //TODO
        String docToStr = "Document: " + name ;
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
}

