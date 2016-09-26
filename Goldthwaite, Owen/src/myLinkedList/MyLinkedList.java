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
       ListNode<E> coolNode = new ListNode<E>(o);
       tail.prev.next=coolNode;
       coolNode.next=tail;
       tail.prev=coolNode;
       size++;
       return true;
    }
    
    public void add(int index, E element)
    {
    	if(index < 0 || index > size)
        	throw new IndexOutOfBoundsException();
    	ListNode<E> addNode = new ListNode<E>(element);
    	ListNode<E> tempNode;
    	tempNode = head;
    	for (int i = size; i > index; i--)
		{			
			
		}
    	
    }
    
    public void addFirst(E o)
    {
        
    }
    
    public void addLast(E o)
    {
        
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
        
    }
    
    public E removeLast()
    {
        
    }
    
    public void clear()
    {
        
    }
    
    public E get(int index)
    {
        if(index < 0 || index >= size)
        	throw new IndexOutOfBoundsException();
        ListNode<E> tempNode = head.next;
        for(int i = 0; i <= index; i++)
        	tempNode=tempNode.next;
        return (E)tempNode;
    }
    
    public boolean isEmpty()
    {
        
    }
    
    public E remove()
    {
        
    }
    
    public E remove(int index)
    {
        
    }
    
    public E set(int index, E element)
    {
        
    }
    
    public int size()
    {
        return size;
    }
    
    public String toString()
    {
        
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