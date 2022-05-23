package com.company;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class TwoWayUnorderedListWithHeadAndTail<E> implements IList<E>{

    private class Element{
        public Element(E e) {
            // TODO
            value = e;
        }
        public Element(E e, Element next, Element prev) {
            this.value = e;
            this.next = next;
            this.prev = prev;
        }
        //TODO

        E value;
        Element next;
        Element prev;

        public E getValue() {return value;}

        public Element getNext() {return next;}

        public Element getPrev() {return prev;}

        public void setValue(E object) {this.value = object;}

        public void setNext(Element next) {this.next = next;}

        public void setPrev(Element prev) {this.prev = prev;}
    }

    Element head;
    Element tail;
    // can be realization with the field size or without
    int size;

    private class InnerIterator implements Iterator<E>{
        Element pos;
        // TODO maybe more fields....

        public InnerIterator() {
            //TODO
            this.pos = head;
        }
        @Override
        public boolean hasNext() {
            //TODO
            if(pos == null)
                return false;
            return pos.getNext()!=null;
        }

        @Override
        public E next() {
            //TODO
            if(pos == null) return null;
            E object = pos.getValue();
            pos = pos.getNext();
            return object;
        }
    }

    private class InnerListIterator implements ListIterator<E>{
        Element p;

        public InnerListIterator(){
            p = head;
        }
        // TODO maybe more fields....

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();

        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            if(p == null)
                return false;
            return p.getNext()!=null;
        }

        @Override
        public boolean hasPrevious() {
            // TODO Auto-generated method stub
            if(p == null)
                return false;
            return p.getPrev()!=null;
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            if(p == null)
                return null;
            E object = p.getValue();
            p = p.getNext();
            return object;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public E previous() {
            // TODO Auto-generated method stub
            if(p == null)
                return null;
            E object = p.getValue();
            p = p.getPrev();
            return object;
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            // TODO Auto-generated method stub
            this.p.setValue(e);
        }
    }

    public TwoWayUnorderedListWithHeadAndTail() {
        // make a head and a tail
        head=null;
        tail=null;
    }

    @Override
    public boolean add(E e) {
        Element elem = new Element(e);
        if(head == null){
            head = elem;
            tail = elem;
            return true;
        }
        if(tail == head)
        {
            tail = elem;
            tail.setPrev(head);
            head.setNext(tail);
            return true;
        }
        elem.setPrev(tail);
        tail.setNext(elem);
        tail = elem;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > this.size() )
            throw new IndexOutOfBoundsException();
        Element newElem;
        if(index == 0){
            newElem = new Element(element, head, null);
            head.setPrev(newElem);
            head = newElem;
        }
        else if(index == this.size()){
            newElem = new Element(element, null, tail);
            tail.setNext(newElem);
            tail = newElem;
        }
        else {
            Element actElem = getElement(index - 1);
            newElem = new Element(element, actElem.next, actElem);
            actElem.setNext(newElem);
            //wsadzam na miejsce poprzedniego element
            newElem.getNext().setPrev(newElem);
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public boolean contains(E element) {
        //uzywam napisanej juz wczesniej metody
        return indexOf(element)!=-1;
    }

    @Override
    public E get(int index) {
        //uzywam napisanej nizej metody
        Element actElem=getElement(index);
        return actElem.getValue();
    }

    @Override
    public E set(int index, E element) {
        if(index < 0 || index >= size())
            throw new NoSuchElementException();
        Element actElem = getElement(index);
        E val = actElem.getValue();
        actElem.setValue(element);
        return val;
    }

    @Override
    public int indexOf(E element) {
        int pos = 0;
        Element actElem = head;
        while(actElem!=null){
            if(actElem.getValue().equals(element)) return pos;
            pos++;
            actElem=actElem.getNext();
        }
        return -1;

    }

    @Override
    public boolean isEmpty() {
        //TODO
        return head==null;
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
    public E remove(int index) {
        //TODO
        if(index<0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }

        E value;

        if(index==0){
            value = head.getValue();
            if(head == tail) {
                head = null;
                tail = null;
            }
            else {
                head = head.getNext();
                head.setPrev(null);
            }
            return value;
        }
        if(index == size()-1)
        {
            value = tail.getValue();
            tail = tail.getPrev();
            tail.setNext(null);
            return value;
        }
        Element actElem = getElement(index-1);
        value = actElem.getNext().getValue();
        actElem.setNext(actElem.getNext().getNext());
        actElem.getNext().setPrev(actElem);
        return value;
    }

    @Override
    public boolean remove(E e) {
        //uzywam wwczesniej napisanych metod
        remove(indexOf(e));
        return true;
    }

    @Override
    public int size() {
        //TODO
        int pos = 0;
        Element actElem = head;
        while(actElem != null){
            pos++;
            actElem = actElem.getNext();

        }
        return pos;
    }
    public String toStringReverse() {
        InnerListIterator iter=new InnerListIterator();
        while(iter.hasNext())
            iter.next();
        String retStr="";
        //TODO use reverse direction of the iterator
        while(iter.hasPrevious()){
            retStr+="\n"+iter.previous();
        }
        retStr+="\n"+iter.previous();
        return retStr;
    }

    public void add(TwoWayUnorderedListWithHeadAndTail<E> other) {
        //TODO
        if(this ==other || other.head == null)
            return;

        if(this.head == null)
        {
            this.head = other.head;
            this.tail = other.tail;
        }
        else if(this.head == this.tail)
        {
            this.head.setNext(other.head);
            this.head.getNext().setPrev(this.head);
            this.tail = other.tail;
        }
        else {
            this.tail.setNext(other.head);
            this.tail.getNext().setPrev(this.tail);
            this.tail = other.tail;
        }
        other.head = null;
        other.tail = null;
    }


    private Element getElement(int index){
        if(index < 0 || index >= size())
            throw new NoSuchElementException();
        Element actElem=head;
        while(index>0 && actElem!=null){
            index--;
            actElem=actElem.getNext();
        }
        return actElem;
    }
}

