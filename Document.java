package com.company;

import java.util.Scanner;

public class Document{
    public String name;
    public OneWayLinkedList<Link> links;
    public Document(String name, Scanner scan) {
        // TODO
        this.name = name;
        links = new OneWayLinkedList<>();
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

                        links.add(new Link(w.substring(5).toLowerCase()));

                    }
                }
            }
            line = scan.nextLine();
        }
    }
    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    private static boolean correctLink(String link) {
        Boolean flag = Character.isLetter(link.charAt(0));
        return flag;
    }

    @Override
    public String toString() {
        String docToStr = "Document: " + name;
        for(int i = 0; i < links.size(); i++)
            docToStr+=  "\n" + links.get(i).ref;
        return docToStr;
    }

}
