package P1;

/**
 * This class implements a dynamic list sorted from biggest to smallest, 
 * using the Java class Comparable<E> as a means to compare data between
 * nodes. 
 */
public class RSListImpl<E extends Comparable<E>> extends GenericList<E> 
	implements ReversedSortedList<E> {

	public RSListImpl(){
	}
	
	/**
	 * Adds a node to the list, doing a binary search to find the 
	 * position where to insert. 
	 * 
	 * @param data Value of the object to be inserted. 
	 */
	public void add(E data) {
		int L = 0;
		int R = size()-1;
		Node<E> current = first;
		int compare = 1;
		int currPos = 0;
		while(!(L>R)){
			current = first;
			currPos = 0;
			int m = (L+R)/2;
			for(int i = 0; i < m; i++){
				current = current.getNext();
				currPos++;
			}
			compare = data.compareTo(current.getData());
			if(compare < 0) L = m + 1;
			else if(compare > 0) R = m - 1;
			else break;
		}
		
		try {
			if (compare == 1) { //insert before current
				insert(currPos, data);
			} else { 			//insert after current
				insert(currPos+1, data);
			}
		} catch (WrongIndexException e) {
			System.out.println(e);
		}	
	}
	
	/**
	 * Adds a node to the list, doing a normal search to find the 
	 * position where to insert (not binary search). 
	 * 
	 * @param data Value of the object to be inserted. 
	 */
	public void  addNotBinary(E data){
		Node<E> ptr = first;
		Node<E> node = new Node<E>(data);
		if(first == null){
			first = node;
		}else if(data.compareTo(first.data) > 0){
			node.next = first;
			first = node;
		}else{
			while(ptr.next != null){
				if(data.compareTo(ptr.next.data) > 0){
					node.next = ptr.next;
					ptr.next = node;
					break;
				}else{
					ptr = ptr.next;
				}
			}
			if(ptr.next == null){
				ptr.next = node;
			}
		}
		size++;
	}
	
	/**
	 * Searches the list to find a node that has the data passed as a 
	 * parameter, using a binary search algorithm. 
	 *
	 * @param data Data element of the node used for the search. 
	 * @return If the node searched exists, return its position. 
	 * Otherwise return -1. 
	 */	
	@Override
	public int search(E data){
		int L = 0;
		int R = size()-1;
		while(!(L>R)){
			Node<E> current = first;
			int currPos = 0;
			int m = (L+R)/2;
			for(int i = 0; i < m; i++){
				current = current.getNext();
				currPos++;
			}
			int compare = data.compareTo(current.getData());
			if(compare < 0) L = m + 1;
			else if(compare > 0) R = m - 1;
			else return currPos;
		}
		return -1;
	}

	public static void main(String[] args) throws WrongIndexException {
		
		RSListImpl<Double> list = new RSListImpl<Double>();
		
		list.add(7.0);
		list.add(5.0);
		list.add(4.0);
		list.add(8.0);
		list.add(2.0);
		
		System.out.println(list);
		
		list.add(4.5);
		
		System.out.println(list);
		

	}

}

