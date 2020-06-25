package P1;

import java.util.Random;

/**
 * This class is a randomly sorted dynamic list. 
 */
public class RandomSortedListImpl<E> extends GenericList<E> 
	implements RandomSortedList<E> {
	
	public RandomSortedListImpl(){
	}

	/**
	 * Adds a node with specific data to the list, at a random position. 
	 *
	 * @param data Data that the added node will contain. 
	 */
	public void add(E data){
		int rpos = new Random().nextInt(size+1);
		Node<E> current = first;
		Node<E> parent = null;
		for(int i = 0; i < rpos; i++){
			parent = current;
			current = current.next;
		}
		Node<E> node = new Node<E>(data, current); 
		if(parent == null) //true if rpos == 0
			first = node;
		else
			parent.next = node;
		if(current == null) last = node;
		size++;
	}

	public static void main(String[] args) throws WrongIndexException {
		RandomSortedListImpl<Integer> list = new 
			RandomSortedListImpl<Integer>();
		for(int i = 0; i < 10; i++) list.add(i);
		System.out.println(list);
		System.out.println("Result of search(3): " + list.search(3));
	}
}
