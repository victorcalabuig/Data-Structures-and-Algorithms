package P3;

import java.util.HashMap;

/**
 * Node used to implement the Trie interface. It uses a HashMap to store
 * the references to the different child nodes. 
 */
public class TrieNode<E> {
	E data;	
	HashMap<Character, TrieNode<E>> children;
	
	
	public TrieNode(){ 
		children = new HashMap<Character, TrieNode<E>>(); 
	}
	
	
	public TrieNode(E data){ 
		children = new HashMap<Character, TrieNode<E>>();
	       this.data = data;	
	}


	/**
	 * Gets all the arcs that point to the child nodes of the current 
	 * node. These arcs are the keys of the HashMap of the node. 
	 * 
	 * @return Array of characters with all the arcs that come out of the
	 * node. 
	 */
	public Character[] getArcs(){
		Character[] arcs = new Character[children.size()];
		int i = 0;
		for(Character c: children.keySet()){
			arcs[i] = c;
			i++;
		}
		return arcs;
	}
	

	/**
	 * Returns the child node to which the specified arc points to. 
	 */
	public TrieNode<E> getChildNode(Character arc){
		return children.get(arc);
	}
	
	
	/**
	 * Adds a child node to the current node, using the specified arc.
	 * 
	 * @param arc Arc used to point to the new child node.
	 * @param node Node to be inserted as a child node.
	 */
	public void addChildNode(Character arc, TrieNode<E> node){
		children.put(arc, node);
	}
	
	
	/**
	 * Removes the child node of the current node to which the specified
	 * arc points to.
	 */
	public void removeChildNode(Character arc){
		children.remove(arc);
	}

	/**
	 * Returns the number of child nodes the current node has. 
	 */ 
	public int numChildrenNodes(){
		return children.size();
	}

}
