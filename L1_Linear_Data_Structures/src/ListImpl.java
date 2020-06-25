package P1;

/**
 * Standard implementaion of a dynamic list. 
 */
public class ListImpl<E> extends GenericList<E> implements List<E> {

	public ListImpl(){
	}
	
	/**
	 * Appends a node at the end of the list. 
	 *
	 * @param data Data element of the node to be appended.
	 */
	public void append(E data){
		Node<E> node = new Node<E>(data);
		if(last == null){
			first = node;
			last = node;
		}else{
			last.next = node;
			last = node;
		}
		size++;
	}
		
	public static void main(String[] args) throws WrongIndexException {
		ListImpl<Integer> list = new ListImpl<Integer>();
		for(int i = 0; i < 10; i++) list.insert(i,i);
		System.out.println(list);
		System.out.println("Result of search(3): " + list.search(3));	
	}
	
}














