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
      return true;
    }
    
    public void add(int index, E element)
    {
        
    }
    
    public void addFirst(E o)
    {
        
    }
    
    public void addLast(E o)
    {
        
    }
    
    public E getFirst()
    {
        
    }
    
    public E getLast()
    {
        
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