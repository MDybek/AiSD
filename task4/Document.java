package com.company;

import javax.swing.event.ListDataListener;
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
    public int[] getWeights() {
        //TODO
        int[] weights = new int[link.size()];
        for (int i =0; i< weights.length;i++)
            weights[i] = link.get(i).weight;
        return weights;
    }

    public static void showArray(int[] arr) {
        // TODO
        for (int i=0;i< arr.length;i++){
            if(i != arr.length-1)
                System.out.print(arr[i] + " ");
            else
                System.out.print(arr[i]);
        }
    }

    void bubbleSort(int[] arr) {
        showArray(arr);
        //TODO
        int n = arr.length;
        int temp;
        Boolean flag;
        for(int i=0; i < n-1; i++){
            flag = true;
            for(int j=(n-1); j >= 1; j--){
                if(arr[j-1] > arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            if (flag)
                break;
            System.out.println();
            showArray(arr);
        }
        System.out.println();
    }

    public void insertSort(int[] arr) {
        showArray(arr);
        //TODO
        for (int i = arr.length - 1; i > 0; i--)
        {
            for (int j = i; j < arr.length; j++)
            {
                if (arr[j-1] > arr[j])
                {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
            System.out.println();
            showArray(arr);
        }
        System.out.println();
    }
    public void selectSort(int[] arr) {
        showArray(arr);
        //TODO
        for(int i = arr.length-1; i > 0; i--)
        {
            int max_index = 0;
            for(int j = i - 1; j > 0; j--)
            {
                if(arr[j] > arr[max_index])
                    max_index = j;
            }
            if(arr[max_index] > arr[i])
            {
                int temp = arr[i];
                arr[i] = arr[max_index];
                arr[max_index] = temp;
            }
            System.out.println();
            showArray(arr);
        }
        System.out.println();
    }

}
