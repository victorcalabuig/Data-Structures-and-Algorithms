package P1;

/**
 * The purpose of this class is to implement all the methods that the 
 * different lists of this project have in common, with the purpose of not
 * replicating code. These methods are insert(int pos, E data),  
 * delete(int pos), get(int pos), size(), and toString(). 
 */
public abstract class GenericList<E> {
	
	/**
	 * Pointer to the first node of the list.
	 */
	Node<E> first = null;

	/**
	 * Pointer to the last node of the list. 
	 */
	Node<E> last = null;

	/**
	 * Integer to keep track of the numer of nodes in the list.
	 */
	int size = 0;
	
	/**
	 * Inserts a node into the list at a specific position. 
	 *
	 * @param pos Position where the node must be inserted, from 0 t0 size.
	 * @param data Data element of the node to be inserted.
	 */
	public void insert(int pos, E data) throws WrongIndexException{
		if(pos > size || pos < 0){ 
			throw new WrongIndexException(
					"The position " + pos + " is not valid." +
				        "Range: 0 --> " + size);
		}else{
			Node<E> current = first;
			Node<E> parent = null;
			for(int i = 0; i < pos; i++){
				parent = current;
				current = current.next;
			}
			Node<E> node = new Node<E>(data, current);
			if(parent == null) //true if pos = 0;
				first = node;
			else
				parent.next = node;
			if(current == null) last = node; 
			size++;
		}
	}
		
	/**
	 * Deletes a node from the list.
	 *
	 * @param pos Position of the node to be deleted. 
	 */	
	public void delete(int pos) throws WrongIndexException{
		if(validGetPos(size, pos)) {
			if(pos == 0) {
				first = first.next;
				if (first == null) last = null;   
			}                            
            else {   
            	Node<E> parent = first;
            	for(int i = 0; i < pos-1; i++) parent = parent.next;
            	parent.next = parent.next.next;
                if(parent.next == null) last = parent;
            }           
			size--;
		}
	}
	
	/**
	 * Returns the node found at the position specified. 
	 *
	 * @param pos - position of thd node to be deleted, from 0 t0 size-1.
	 */
	public E get(int pos) throws WrongIndexException{
			if(validGetPos(size, pos)){
					Node<E> current = first;
					for(int i = 0; i < pos; i++) current = current.next;
					return current.data;
			}
			return null; //Should never arrive here.
        }


	/**
     * Checks whether the position passed to the calling method is valid.
	 * Such calling method can be delete(int pos) or get(int pos). 
	 *
     * @param size size of the list.
     * @param pos positon passed to the calling method by the user.
     * @return true if the position is valid, throws WrongIndexException
	 * otherwise.
     */
	public boolean validGetPos(int size, int pos)throws WrongIndexException {
			if(first == null)
					throw new WrongIndexException("List is empty.");
			else if(pos < 0 || pos >= size)
					throw new WrongIndexException(
									"The position " + pos + " is not valid." +
									" Range: 0 --> " + (size-1));
			else
					return true;
	}
	
	/**
	 * Looks for the node in the list that contains the data specified as 
	 * a parameter.
	 *
	 * @param data Data that the node searched has. 
	 * @return If the node exists in the list, return its position. Otherwise,
	 * return -1. 
	 */
	public int search(E data){
		int pos = 0;
		Node<E> current = first;
		while(current != null){
				if(current.getData().equals(data)){
						return pos;
				}else{
						current = current.next;
						pos++;
				}
		}
		return -1;
	}

	
	/**
	 * Returns the number of nodes in the list. 
	 */
	public int size(){
			return size;
	}

	@Override
	public String toString(){
			String list = "[";
			Node<E> ptr = first;
			while(ptr != null){
					list += ptr.data + ", ";
					ptr = ptr.next;
			}
			return list;
	}
}
