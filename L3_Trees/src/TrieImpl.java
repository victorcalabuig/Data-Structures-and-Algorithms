package P3;

import java.util.List;
import java.util.LinkedList;

/**
 * Implementation of a Trie that uses String values for the keys that 
 * are located in the arcs of the trie. TrieImmpl uses the class 
 * TrieNode<E> to represent each node, which internally uses a HashMap
 * to map all the subtrees of a given node. 
 */
public class TrieImpl<E> implements Trie<E> {

	TrieNode<E> root;
	int n;		//number of elements
	int nodes;	//number of nodes

	public TrieImpl() {
		root = new TrieNode<E>();
		n = 0; 
		nodes = 1;
	}
	
	
	/**
	 * Adds an element to the trie.
	 * 
	 * @param key Key of the element.
	 * @param data Value of the element.
	 */
	public  void  insert(String key , E data) 
	throws  ExistingElementException {
		int letter = 0; //to iterate through the key
		TrieNode<E> current = root;
		while(letter < key.length()){ //iterate through the key's letters
			if(current.children.get(key.charAt(letter)) == null){
				current.addChildNode(key.charAt(letter), new TrieNode<E>());
				nodes++;
			}
			current = current.getChildNode(key.charAt(letter));
			letter++;			
		}
		if(current.data == null){
			current.data = data; //insert element
			n++;
		}
		else throw new ExistingElementException("Element with key " 
			+ key + " already exists in the Trie.");
	}


	/**
	 * Looks for an element using its key. 
	 * 
	 * @param key Key used to do the search.
	 * @return The value of the element with that key, or throws 
	 * exception if the element is not found. 
	 */ 
    	public E search(String  key) throws  ElementNotFoundException{
		TrieNode<E> current = searchNode(key);
		if(current == null || current.data == null) 
			throw new ElementNotFoundException();
		else
			return current.data;
	}
	
	
	/**
	 * Removes an element from the trie (if it exists, else it throws an
	 * exception. 
	 * 
	 * @param key Key of the element to be removed.
	 */
    	public  void  delete(String  key) throws  ElementNotFoundException{
		TrieNode<E> current = searchNode(key);
		if(current == null || current.data == null) 
			throw new ElementNotFoundException();
		else if(current.numChildrenNodes() != 0) current.data = null;
		else { //no children so cut leaves
			current.data = null;
			for(int i = key.length(); i > 0; i--){
				String subKey = key.substring(0,i);
				if(cutLeaf(subKey) == 0) break;
			}			
		}
		n--; 		
	}
	
	
	/**
	 * Looks for the node in the trie that corresponds to a specific
	 * String. 
	 * 
	 * @parma key String used to find the node.
	 * @return The node that corresponds to that Stirng. This method can
	 * return an emtpy node (if there is no element with that String but 
	 * there are elements whose key has that String as a prefix).
	 */
	public TrieNode<E> searchNode(String key){
		int letter = 0; //to iterate through the key
		TrieNode<E> current = root;
		while (letter < key.length() && current != null){
			current = current.getChildNode(key.charAt(letter));
			letter++;
		}
		return current;
	}
	
	
	/**
	 * Removes an empty leaf of the trie, that is, a node with no child
	 * nodes and that does not store an element. This type of nodes only
	 * appears temporarily when delete(String key) is called. 
	 * 
	 * @param key String that indicates which node will be the candidate 
	 * to be removed (the method checks if such node is a leaf or not 
	 * before cutting it).
	 * @return 1 if the candidate node is removed, 0 if such node was 
	 * not a leaf and therefore isn't removed.  
	 */
	public int cutLeaf(String key)
	{
		int letter = 0; //to iterate throught he key letters.
		TrieNode<E> current = root;
		TrieNode<E> prev = current;
		while(letter < key.length() && current != null) {
			prev = current;
			current = current.getChildNode(key.charAt(letter));
			letter++;
		}
		if (current.numChildrenNodes() == 0 && current.data == null){ 
			prev.removeChildNode(key.charAt(letter-1)); //cut node from trie
			nodes--;
			return 1;
		}
		else return 0;
	}
	
	
	/**
	 * Traverses the tree in preorder to create a list with all the 
	 * elements of the trie.
	 * 
	 * @return Linked List with all the elements. 
	 */
	public  List<E> list(){
		return list(root);
	}
	
	
	/**
	 * Internal method to implement preOrder traversal recursively, adding
	 * the element of the current node to the list in each call. 
	 * 
	 * @param node Node on which the method is applied. In the initial 
	 * call this node will be the root of the trie. 	 
	 * @return Linked List with the elements of the nodes traversed. 
	 */
	public List<E> list(TrieNode<E> node){
		LinkedList<E> lst = new LinkedList<E>();
		if(node == null) return lst;
		if(node.data != null) lst.add(node.data);
		Character[] arcs = node.getArcs();
		for(int i = 0; i < arcs.length; i++)
			lst.addAll(list(node.getChildNode(arcs[i])));
		return lst;
	}

	/**
     	 * Gets all the elements of the trie whose key starts with a 
    	 * specific prefix. 
    	 * 
    	 * @param prefix Prefix used to get the elements.
    	 * @return Linked List with all the elements selected. 
    	 */    
   	public  List <E> prefixSearch(String  prefix){
		TrieNode<E> current = searchNode(prefix);
		return list(current);
	}
	
	
   	/**
    	 * Returns the number of elements in the trie.
    	 */    
	public  int  size(){
		return n;
	}
    
    
   	/** 
    	 * Returns the number of nodes in the trie.
     	 */    
	public  int  numNodes (){
		return nodes;
	}
	
	
	/**
	 * Internal method used to implement the toString() method. It 
	 * traverses the tree recurively using preorder, printing in each 
	 * call a single node (both if it contains an element or not). 
	 */
	public String preOrderToString(TrieNode<E> node, String indent, 
		int level, char arc)
		{
		String str = indent + "(" + level + ") -- " + arc + " --> {";	
		if(node.data == null) str += "/"; //String representation of empty node
		else str += node.data;
		
		Character[] arcs = node.getArcs();
		str += "} , [";
		for(int j = 0; j < arcs.length; j++) str += arcs[j] + ",";
		if(arcs.length != 0) str = str.substring(0, str.length()-1);
		str += "]\n";
		
		indent += "   ";
		level++;
		for(int i = 0; i < node.children.size(); i++){ //for each child node:
			TrieNode<E> child = node.getChildNode(arcs[i]);
			str += preOrderToString(child, indent, level, arcs[i]);
		}
		return str;
	}
	
	
	/**
	 * Converts a trie into a String sequence.
	 * 
	 * @return String representation of the trie.
	 */
	public String toString(){
		String nomen = "(depth level) -- arc --> {element stored} , " 
			+ "[list of arcs]\n";
		return  nomen + preOrderToString(root, "", 0, '@');
	}
	
	
	public static void main(String[] args)
	throws ExistingElementException, ElementNotFoundException {
		TrieImpl<String> trie = new TrieImpl<String>();		
		
		trie.insert("arbol","arbol");						
		System.out.println(trie + "\nElements: " + trie.size() + "\nNodes: "
			+ trie.numNodes() + "\n");
			
		System.out.println("search(arbol) = " + trie.search("arbol"));
		
		trie.delete("arbol");
		
		for(int i = 0; i < 20; i++){
			String num = Integer.toString(i);
			trie.insert(num, num);
		}
		
		System.out.println(trie + "\nElements: " + trie.size() + "\nNodes: "
			+ trie.numNodes() + "\n");
			
		System.out.println(trie.prefixSearch("1"));
	}
}








