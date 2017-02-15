import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;


public class DoublyLinkedList<AnyType> implements List<AnyType>
{
  private static class Node<AnyType>
  {
    private AnyType data;
    private Node<AnyType> prev;
    private Node<AnyType> next;

    public Node(AnyType d, Node<AnyType> p, Node<AnyType> n)
    {
      setData(d);
      setPrev(p);
      setNext(n);
    }

    public AnyType getData() { return data; }

    public void setData(AnyType d) { data = d; }

    public Node<AnyType> getPrev() { return prev; }

    public void setPrev(Node<AnyType> p) { prev = p; }

    public Node<AnyType> getNext() { return next; }

    public void setNext(Node<AnyType> n) { next = n; }
  }

  private int theSize;
  private int modCount;
  private Node<AnyType> header;
  private Node<AnyType> trailer;

  public DoublyLinkedList()
  {
    header = new Node<AnyType>(null, null, null);
    trailer = new Node<AnyType>(null, null, null);
    modCount = 0;
    clear();
  }

  public void clear()
  {
    header.setNext(trailer);
    trailer.setPrev(header);
    theSize = 0;
  }

  public int size()
  {
    return theSize;
  }

  public boolean isEmpty()
  {
    return (size() == 0);
  }
  /**
   * get the value of a node in the list
   */
  public AnyType get(int index)
  {
	  checkIndex(index,theSize);//check the illegal index
	   Node<AnyType> current= getNode(index);//get the node
	   return current.getData();//get the data of the node

  }
/**
 *set a value to a node in the list 
 */
  public AnyType set(int index, AnyType newValue)
  {  
	  checkIndex(index,theSize);
	  Node<AnyType> current=getNode(index); 

	  current.setData(newValue);//set new value to the node 
	  return (AnyType) current;
		  
  }
  /**
   * print the linked list
   */
	public void display(){
		if(header==null){
			return;
		}
		Node<AnyType> current=header.next.next;
		while(current!=null){
			System.out.print( current.data + ",");
			current=current.next;
		}
		
		System.out.println(" ");
	} 

  

  public boolean add(AnyType newValue)
  {
    add(size(), newValue);
    return true;
  }

  public void add(int index, AnyType newValue)
  {
	  checkIndex(index,theSize);

	  if(isEmpty()){
		  Node<AnyType> newNode= new Node(newValue,header,trailer); 
		  header.next= newNode;
		  trailer.prev=newNode;
		  theSize++;
		  modCount++;
		 // System.out.println(newNode.data);
	  }
	  else{
	  
	  Node<AnyType> current = getNode(index);
	  Node<AnyType> next = current.next;
	  Node<AnyType> prev = current.prev;
	  Node<AnyType> nnode=new Node(newValue,current,next);
	 
	  current.next=nnode;
	  next.prev=nnode;
	  
	  modCount++;
	    
	  theSize++;
	  }
  }

  public AnyType remove(int index)
  {
    return remove(getNode(index));
  }

  public Iterator<AnyType> iterator()
  {
    return new LinkedListIterator();    
  }

  private Node<AnyType> getNode(int index)
  {
    return (getNode(index, 0, size()-1));
  }
  /**
   * 
   * @param index the node to get
   * @param lower the first node
   * @param upper the last node
   * @return
   */

  private Node<AnyType> getNode(int index, int lower, int upper)
  {
	 Node<AnyType> current=header;//start at the header
	 for(int i=lower;i<=upper;i++){//find to the index node
		 if(index!=i){ current=current.next; }
		 else{
			 	break;
		 	}	
				
		}
	 return current;
		
	}
	



  private AnyType remove(Node<AnyType> currNode)
  {	  
	 
	  if(currNode==null) return null;
	  AnyType index=currNode.getData();//remove date for return
	  Node<AnyType> next = currNode.getNext();
	  Node<AnyType> prev = currNode.getPrev();
	  
	  next.setPrev(prev);
	  prev.setNext(next);
	  currNode=null;
	  modCount++;
	  theSize++;
	  
	  return index;
	  
  }

  private class LinkedListIterator implements Iterator<AnyType>
  {
    private Node<AnyType> current;
    private int expectedModCount;
    private boolean okToRemove;

    LinkedListIterator()
    {
      current = header.getNext();
      expectedModCount = modCount;
      okToRemove = false;
    }

    public boolean hasNext()
    {
      return (current != trailer);
    }

    public AnyType next()
    {
      if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
      if (!hasNext())
        throw new NoSuchElementException();

      AnyType nextValue = current.getData();
      current = current.getNext();
      okToRemove = true;
      return nextValue;
    }

    public void remove()
    {
      if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
      if (!okToRemove)
        throw new IllegalStateException();

      DoublyLinkedList.this.remove(current.getPrev());
      expectedModCount++;
      okToRemove = false;
    }
  }
  protected void checkIndex(int i,int n){
	  if(i<0||i>n)
		  throw new IndexOutOfBoundsException("Illegal"+i);
  }
}



