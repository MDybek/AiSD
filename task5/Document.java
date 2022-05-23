package com.company;

import java.util.ListIterator;
import java.util.Scanner;
import java.lang.Math;

import static java.lang.Math.min;

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


    public void iterativeMergeSort(int[] arr) {
        showArray(arr);
        //TODO
        for(int a =1;a< arr.length;a*=2) {

            for(int L=0; L<arr.length; L+=(2*a)) {

                int Mid=min(L+a-1,arr.length-1);
                int R=min(L+2*a-1,arr.length-1);
                int i, j, k;
                int n1 = Mid - L + 1;
                int n2 = R - Mid;
                int[] LSide = new int[n1];
                int[] RSide = new int[n2];

                for (i = 0; i < n1; i++)
                    LSide[i] = arr[L + i];

                for (j = 0; j < n2; j++)
                    RSide[j] = arr[Mid + 1 + j];

                i = 0;
                j = 0;
                k = L;

                while (i < n1 && j < n2) {
                    if (LSide[i] <= RSide[j]) {
                        arr[k] = LSide[i];
                        i++;
                    }
                    else {
                        arr[k] = RSide[j];
                        j++;
                    }
                    k++;
                }

                while (i < n1) {
                    arr[k] = LSide[i];
                    i++;
                    k++;
                }

                while (j < n2) {
                    arr[k] = RSide[j];
                    j++;
                    k++;
                }
            }
            System.out.println();
            showArray(arr);
        }
        System.out.println();
    }

    public void radixSort(int[] arr) {
        showArray(arr);
        //TODO
        int maks = 0;
        for(int i =0;i< arr.length;i++){
            if (arr[i]>maks)
                maks=arr[i];
        }
        int maksdigits = (int) Math.log10(maks)+1;
        int param = (int) Math.pow(10, maksdigits);
        for(int exp = 1; exp < param; exp *= 10) {
            int resultArray[] = new int[arr.length];
            int i;
            int countVal[] = new int[10];
            for (i = 0; i < arr.length; i++)
                countVal[ (arr[i]/exp)%10 ]++;
            for (i = 1; i < 10; i++)
                countVal[i] += countVal[i - 1];
            for (i = arr.length - 1; i >= 0; i--) {
                resultArray[countVal[ (arr[i]/exp)%10 ] - 1] = arr[i];
                countVal[ (arr[i]/exp)%10 ]--;
            }
            for (i = 0; i < arr.length; i++)
                arr[i] = resultArray[i];

            System.out.println();
            showArray(arr);
        }
        System.out.println();
    }
}
