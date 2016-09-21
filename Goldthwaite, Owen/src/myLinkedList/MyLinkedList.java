package myLinkedList;

import java.util.*;

public class MyLinkedList<E>
{    
	private int size;
	ListNode head;
	ListNode tail;
	
    public MyLinkedList()
    {
    	head = new ListNode(null);
		tail = new ListNode(null);

    }
    
    public boolean add(E o)
    {
        
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