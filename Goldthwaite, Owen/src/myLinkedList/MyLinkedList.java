package myLinkedList;

import java.util.*;

public class MyLinkedList<E>
{    
	private int size;
	private ListNode<E> head;
	private ListNode<E> tail;
	
    public MyLinkedList()
    {
    	head = new ListNode<E>(null);
		tail = new ListNode<E>(null, head, null);
        head.next=tail;
    }
    
    public boolean add(E o)
    {
    	add(size, o);
    	return true;
    }
    
    public void add(int index, E element)
    {
    	if(index < 0 || index > size)
        	throw new IndexOutOfBoundsException();
    	ListNode<E> addNode = new ListNode<E>(element, getNode(index-1), getNode(index));
    	getNode(index).prev = addNode;
    	getNode(index - 1).next = addNode;
    	
		
	size++;
    	
    }
     
    private ListNode<E> getNode(int index)
    {
    	 if(index >= size) 
    		 return tail;
    	 if(index < 0)
    		 return head;
    	 ListNode<E> tempNode = head;
         for(int i = 0; i <= index; i++)
         	tempNode=tempNode.next;	 
    	return tempNode;
    }
    
    public void addFirst(E o)
    {
    	add(0, o);
    }
    
    public void addLast(E o)
    {
    	add(size, o);
    }
    
    public E getFirst()
    {
        return (E) head.next;
    }
    
    public E getLast()
    {
    	return (E) tail.prev;
    }
    
    public E removeFirst()
    {
    	if(size == 0)
    		throw new NoSuchElementException();
    	ListNode<E> tempNode = head.next;
    	remove(0);
    	return tempNode.value;
    }
    
    public E removeLast()
    {
    	if(size == 0)
    		throw new NoSuchElementException();
    	ListNode<E> tempNode = tail.prev;
    	remove(size-1);
    	return tempNode.value;
    }
    
    public void clear()
    {
        head.next = tail;
        tail.prev = head;
        size=0;
    }
    
    public E get(int index)
    {
        if(index < 0 || index >= size)
        	throw new IndexOutOfBoundsException();
        
        return getNode(index).value;
    }
    
    public boolean isEmpty()
    {
        if(size == 0)
        	return true;
        else 
        	return false;
    }
    
    public E remove()
    {
    	if(size == 0)
    		throw new NoSuchElementException();
    	
    	return remove(0);
    }
    
    public E remove(int index)
    {
    	if(index < 0 || index >= size)
        	throw new IndexOutOfBoundsException();
    	
    	ListNode<E> tempNode = getNode(index);
    	
    	getNode(index - 1).next = getNode(index + 1);
    	getNode(index + 1).prev = getNode(index - 1);
    	size--;
    	return tempNode.value;
    }
    
    public E set(int index, E element)
    {
    	if(index < 0 || index >= size)
        	throw new IndexOutOfBoundsException();
    	ListNode<E> setNode = new ListNode<E>(element);
    	ListNode<E> beingSet =getNode(index);
    	ListNode<E> tempNode;
    	
    	tempNode = getNode(index);
    	setNode.next = getNode(index + 1);
    	setNode.prev = getNode(index - 1);
    	beingSet = setNode;
    	return tempNode.value;
    	
    }
    
    public int size()
    {
        return size;
    }
    
    //public void insert(int index, MyLinkedList<E> listInsert)
    {
    	
    }
    
    public String toString()
    {
        String printString = "[";
    	for(int i = 0; i < size; i++)
        {
           printString += getNode(i).value;
           if(i < size-1)
        	   printString +=", ";
        }
    	printString += "]";
    	System.out.println(printString); //to test printing
    	return printString; 
    }
    
    private class ListNode<E>
    {
        public E value;
        public ListNode<E> prev;
        public ListNode<E> next;
    
        public ListNode(E initValue)
        {
            value = initValue;
            prev = null;
            next = null;
        }
    
        private ListNode(E initValue, ListNode<E> initPrev, ListNode<E> initNext)
        {
            value = initValue;
            prev = initPrev;
            next = initNext;
        }
    }
}