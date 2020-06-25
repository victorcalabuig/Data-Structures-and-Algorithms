package P1;

class Node<E> {
	E data;
	Node<E> next;

	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}
	public Node(E data) {
		this(data, null);
	}

	public E getData(){
		return data;
	}

	public Node getNext(){
		return next;
	}

	public void setData(E data){
		this.data = data;
	}
	
	public void setNext(Node<E> next){
		this.next = next;
	}
	
	@Override
	public String toString(){
		String node = "(" + data + ")";
		return node;
	}

	public static void main(String[] args){
		Node<Integer> node = new Node<Integer>(10);
		node = new Node<Integer>(20, node);
		Node<Integer> ptr = node;
		while(ptr != null){
			System.out.println(ptr.getData());
			ptr = ptr.next;
		}
		System.out.println(node.data);		
	}

}
