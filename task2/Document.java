package com.company;


import java.util.Scanner;

public class Document{
    public String name;
    public TwoWayUnorderedListWithHeadAndTail<Link> link;
    public Document(String name, Scanner scan) {
        this.name=name;
        link=new TwoWayUnorderedListWithHeadAndTail<Link>();
        load(scan);
    }
    public void load(Scanner scan) {
        //TODO

        String line = scan.nextLine();
        while (!line.equals("eod")) {

            String[] words = line.split("\\s");
            for(String w:words) {

                if(w.length() >5){

                    if(w.substring(0,5).toLowerCase().equals("link=") && correctLink(w.substring(5, w.length()))){

                        link.add(new Link(w.substring(5).toLowerCase()));

                    }
                }
            }
            line = scan.nextLine();
        }
    }
    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    public static boolean correctLink(String link) {
        //TODO
        Boolean flag = Character.isLetter(link.charAt(0));
        return flag;
    }

    @Override
    public String toString() {
        // TODO
        String docToStr = "Document: " + name;
        for(int i = 0; i < link.size(); i++)
            docToStr+=  "\n" + link.get(i).ref;
        return docToStr;
    }

    public String toStringReverse() {
        String retStr="Document: "+name;
        if (link.size() > 0)
            return retStr+link.toStringReverse()+"\n";
        else
            return retStr+"\n";
    }

}
