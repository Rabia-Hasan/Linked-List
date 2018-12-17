public interface List{
	/**
	return true/false depending upon data_container array/linkedlist
	**/	
	public	boolean isEmpty();//done
	/**
	return total number of data elements present in list
	**/
	public	int size();//done
	/**
	delete every thing in list and make it empty
	**/
   public void clear();//done
	/**
	return true if element is present in list
	**/
	public	boolean contains(Object element);
	/**
	return element present at given index, throw exception if index is out of bound
	**/
   public Object get(int index);
	/**
	replace the old element at given index with new element and return old element,
	throw exception if index is out of bound
	**/
	public	Object set(int index, Object element);
	/**
	add the given element at end of list
	**/
	public	void add(Object element);
	/**
	add the given element at given index and shift the old elements to right,
	throw exception if index is out of bound
	**/
	public	void add(int index, Object element);
	/**
	remove the given object and return it, return null if not present
	**/
	public	Object remove(Object element);
	/**
	remove the object at given index and return it, throw exception if index is out of bound
	**/
	public	Object remove(int index);
}