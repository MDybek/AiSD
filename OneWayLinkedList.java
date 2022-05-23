package com.company;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class OneWayLinkedList<E> implements IList<E>{

    private class Element{
        public Element(E e) {
            this.object=e;
        }
        E object;
        Element next=null;

        public E getObject() {return object;}

        public void setObject(E object) {this.object = object;}

        public Element getNext() {return next;}

        public void setNext(Element next) {this.next = next;}
    }


    Element sentinel =null;

    private class InnerIterator implements Iterator<E>{
        // TODO
        Element actElem;

        public InnerIterator() {
            // TODO
            actElem= sentinel;
        }
        @Override
        public boolean hasNext() {
            // TODO
            return actElem.getNext()!=null;
        }

        @Override
        public E next() {
            // TODO
            E object = actElem.getObject();
            actElem=actElem.getNext();
            return object;
        }
    }

    public OneWayLinkedList() {
        // make a sentinel
        // TODO
        sentinel = new Element(null);

    }

    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean add(E e) {
        // TODO Auto-generated method stub //

        Element newElem=new Element(e);
        if(sentinel.getNext() ==null){
            sentinel.setNext(newElem);
            return true;
        }
        Element tail= sentinel.getNext();
        while(tail.getNext()!=null)
            tail=tail.getNext();
        tail.setNext(newElem);
        return true;
    }

    @Override
    public void add(int index, E element) throws NoSuchElementException {
        // TODO Auto-generated method stub
        if(index<0) throw new IndexOutOfBoundsException();
        Element newElem=new Element(element);
        if(index==0)
        {
            newElem.setNext(sentinel.getNext());
            sentinel.setNext(newElem);
        }
        else{
        Element actElem=getElement(index-1);
        newElem.setNext(actElem.getNext());
        actElem.setNext(newElem);
        }
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        sentinel.setNext(null);
    }

    @Override
    public boolean contains(E element) {
        // TODO Auto-generated method stub
        return indexOf(element)>=0;
    }

    @Override
    public E get(int index) throws NoSuchElementException {
        // TODO Auto-generated method stub
        try{
            Element actElem=getElement(index);
        }
        catch(IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
        Element actElem=getElement(index);
        return actElem.getObject();
    }


    private Element getElement(int index){
        if(index<0) throw new IndexOutOfBoundsException();
        Element actElem=sentinel.getNext();
        while(index>0 && actElem!=null){
            index--;
            actElem=actElem.getNext(); }
        if (actElem==null)
            throw new IndexOutOfBoundsException();
        return actElem;
    }

    @Override
    public E set(int index, E element) throws NoSuchElementException {
        // TODO Auto-generated method stub
        Element actElem=getElement(index);
        E elemData=actElem.getObject();
        actElem.setObject(element);
        return elemData;
    }

    @Override
    public int indexOf(E element) {
        // TODO Auto-generated method stub
        int pos=0;
        Element actElem = sentinel.getNext();
        while(actElem!=null)
        {
            if(actElem.getObject().equals(element))
                return pos; pos++;
            actElem=actElem.getNext();
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return sentinel.getNext() == null;
    }

    @Override
    public E remove(int index) throws NoSuchElementException {
        // TODO Auto-generated method stub

        if(index<0 || sentinel.getNext()==null) {
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            E retValue= sentinel.getNext().getObject();
            sentinel = sentinel.getNext();
            return retValue;
        }
        Element actElem=getElement(index-1);
        if(actElem.getNext()==null)
            throw new IndexOutOfBoundsException();
        E retValue=actElem.getNext().getObject();
        actElem.setNext(actElem.getNext().getNext());
        return retValue;
    }


    @Override
    public boolean remove(E e) {
        // TODO Auto-generated method stub
        if (sentinel.getNext() == null)
            return false;
        Element actElem = sentinel;
        while (actElem.getNext() != null && !actElem.getNext().getObject().equals(e))
            actElem = actElem.getNext();
        if (actElem.getNext() == null)
            return false;
        actElem.setNext(actElem.getNext().getNext());
        return true;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        int pos=0;
        Element actElem = sentinel.getNext();
            while(actElem!=null) {
                pos++;
                actElem=actElem.getNext();
            }
            return pos;

    }

    public void removeeven(){
        Element actElem = sentinel;
        if(actElem.getNext() != null){
            while (actElem.getNext()!=null){
                actElem.setNext(actElem.getNext().getNext());
                actElem = actElem.getNext();
                if (actElem == null){
                    break;
                }
            }
        }
    }
}


