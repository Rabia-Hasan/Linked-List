/*Group
Hamza Sarwar SP16-BCS-115
Rabia Hasan Zaheer SP16-BCS-155
Rana Shoaib SP16-BCS-163*/
/*Class Linked List */
/*Implementation of all methods in List.java*/

public class LinkedList implements List
{

	private Node head,tail;
	private int size=0;

	/*==================IMPLEMENTATION OF METHODS FROM List.java===========================*/

	public	boolean isEmpty()
	{
		return head==null;
	}

	public	boolean contains(Object element)
	{
		for(Node i=head;i!=null;i=i.next)
		{
			if(i.item.equals(element)) //compare element with data part of all nodes
				return true;
		}
		return false;
	}

	public void clear()
	{
	  head = null; //break head link
	  tail = null; // break tail link
	  size = 0;
	}

	public	void add(Object element)
	{
		Node node=new Node(element);//Given a data part, create a node

		if(isEmpty())
		{
			head=node;
			tail=node;
		}
		else
		{
			tail.next=node;
			node.prev=tail;
			tail=node;
		}
		size++;
	}

	public Object remove(Object element)
	{
	Node temp=head;
	int index=0;

	while(head!=null)//List must not be empty
	{
		 if (!temp.item.equals(element))
		{
			  temp = temp.next;
			  index++;
		 }
		 else
			 break;

	}
	//Out of bound
	if(index==size)
	 return null;
		 remove(index);//Calling Remove(int index) function
		 return temp;
   }


	public Object remove(int index)
	{
	//Checking index validity
	 if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException("Invalid index " + index);

      Object temp = null;
	 //Remove first node
	 if(index == 0)
	  {
		  temp = head.item;
		  head = head.next;
		  head.prev = null;
		  size--;
		  return temp;
	  }
	  //Remove Last node
	  if(index == size - 1) {
		  temp = tail.item;
		  tail = tail.prev;
		  tail.next = null;
		  size--;
		  return temp;
	  }

	  Node temp2 = head;
      for (int i = 0; i < index; i++)
	   temp2 = temp2.next;
       //removing node
	   temp2.prev.next = temp2.next;
	   temp2.next.prev = temp2.prev;
	   size--;
	   return temp2.item;
	}




	public Object get(int index)
	{
		 //Checking index validity
		 if(index<0&&index>=size)
			   throw new IndexOutOfBoundsException("Invalid index " + index);
		   Node temp=head;
		   //Works till index is found
		   for (int i = 0; i < index; i++)
    	   temp = temp.next;

	  return temp.item;//Returns data on index

}

	public	Object set(int index, Object element)
	{
	//Checking Index validity
	if (index < 0 || index >= size)
	        throw new IndexOutOfBoundsException("Invalid index " + index);

	  Node temp = head;
	  int i = 0;
	  Object value = null;

	  //Loop will work till index is found
	  while (i != index) {
		  temp = temp.next;
		  i++;
	  }
	  //Replace old value with new
	  value = temp.item;
	  temp.item = element;
	  return value;//return old value

	}

	public	void add(int index, Object element)
        {
		//Checking index validity
		if (index < 0 || index > size)
        throw new IndexOutOfBoundsException("Invalid index " + index);

		Node newnode = new Node(element);

		if(head==null)//If list is empty
			head=newnode;

		else if(index==0)//Add at head
		{
			newnode.next = head;
			head.prev = newnode;
			head = newnode;
		}

		else if(index==size)//add at tail
		{
			tail.next = newnode;
			newnode.prev = tail;
			tail = newnode;
		}

		else//For middle
		{
			Node temp = head;
			for (int i = 0; i < index; i++)  //Loop will work till index is found
				temp = temp.next;
      	   //Insertion
			newnode.prev = temp.prev;
			temp.prev.next = newnode;
			newnode.next = temp;
			temp.prev = newnode;


		}
          size++;
		}



	public int size()
	{
		return size;
	}


	public String toString()
	{
		String res="";
		for(Node i=head;i!=null;i=i.next)
			res+="\t"+i;

		return res;
	}

	//=================================Node Class============================================================
	/**
	a class to convert any object into node structure with next and previous references.
	**/
	private static class Node {
        Object item;//data part
        Node next;
        Node prev;

        Node(Object element) {
            this.item = element;//given object has become data
            this.next = null;
            this.prev = null;
        }
		public String toString()
		{
			return ""+item;//toString of item would be called
		}
    }
	//======================================================================================================

}
