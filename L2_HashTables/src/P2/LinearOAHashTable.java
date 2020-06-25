package P2; 

/**
 * This class implements the abstract data type "Permanent Dictionary" 
 * through a hash table. This hash table receives the specific name of 
 * Linear Open Adressing Hash Table since it solves collisions using the 
 * open addressing method. Both the key and the value of this dictionary 
 * are generic, represented by K and V.  
 * 
 */
public class LinearOAHashTable<K, V> implements PermanentDictionary<K, V> {
	
	TableEntry<K,V>[] table; //buckets vector
	int m; //number of buckets
	int n; //number of entries (current size)

	/**
	 * Constructor that creates a hashtable with the amount of buckets 
	 * that the user indicates. 
	 * 
	 * @param m Number of buckets the hashtable will have. 
	 */
	public LinearOAHashTable(int m){
		this.m = m;
		table = new TableEntry[m];
		this.n = 0;
	}
	
	/**
	 * TableEntry is an internal class of the hash table, and it is used 
	 * to represent each data pair of the dicitionary. Therefore, each 
	 * entry has a generic type key and generic type value. 
	 */
	class TableEntry<K, V> {
		K key; 
		V value;

		TableEntry(K key, V value){
			this.key = key;
			this.value = value;
		}

		/**
		 * Compares different TableEntries.  Two entries are equal if 
		 * their keys are the same. 
		 */ 
		public boolean equals (Object obj) {
			if(obj instanceof LinearOAHashTable<?,?>.
				       TableEntry<?,?> == false) return false;	
			TableEntry<K,V> ent = (TableEntry<K,V>) obj;
			return ent.key.equals(key);
		}
		
		/**
		 * The string representation of a TableEntry consists of its
		 * key and value, from left to right respectively, inside a 
		 * parenthesis separated by a coma: (key,value). 
		 */
		public String toString(){
			return "(" + key + "," + value + ")";
		}
	}
	
	/**
	 * Implements the hash function of the hash table, used
	 * to determine in which bucket each TableEntry is placed. First it 
	 * obtains an integer from the TableEntry's key using the java
	 * hashCode() method. It makes it positive, and then it applies the 
	 * division method. 
	 * 
	 * @param key Key of the TableEntry to which the hash function is 
	 * applied.
	 * @return The index that indicates in which bucket the TableEntry 
	 * must be stored. 
	 */
	int hash(K key) {
		return Math.abs(key.hashCode()) % m;
	}
	
	/**
	 * This method is a wrapper method for the method
	 * insertInternal(K key, V value). This is done with the purpose of
	 * reusing the insertInternal method in a different class called 
	 * ExpandableLinearOAHashTable, to modify the functionality of the 
	 * insert method in that class. 
	 */
	public void insert(K key, V value) throws ExistingElementException,
	      FullDictionaryException
	{
		insertInternal(key, value);
	}

	/**
	 * Inserts an element (represented by a TableEntry object) into the 
	 * hash table. This method will only throw exceptions if the hash 
	 * table is already full (n = m) or if the element trying to be 
	 * inserted already exists in the hash table (2 elements are 
	 * considered equal if their key is the same, no matter the value 
	 * they are linked to).
	 * 
	 * @param key - The key of the element, used for the hash function and 
	 * to compare the element with other elements.
	 * @param value - The value of the element, associated to the key. 
	 */
	public void insertInternal(K key, V value) throws ExistingElementException,
	      FullDictionaryException
	{
		//check if bucket is full already
		if (m == n) throw new FullDictionaryException("The dictionary" +
				"is full.");
		
		TableEntry<K,V> newEntry = new TableEntry<K,V>(key, value);
		int pos = hash(newEntry.key);
		boolean inserted = false;
		while(!inserted){		
			TableEntry<K,V> currEntry = table[pos];
			if(currEntry == null) {
				table[pos] = newEntry;
				n++;
				inserted = true;
			}else { 
				//check if collision OR key already exists
				if (newEntry.equals(currEntry)) 
					throw new ExistingElementException(
						"The element with key " + newEntry.key 
						+ " already exists at bucket "
						+ pos + ".");
				else {
                    /*
					System.out.println(
						"------\n"
						+ "Key Collision in bucket " + pos + ":\n"
						+ "\tElement to be inserted: "
						+ "{" + newEntry.key + "," + newEntry.value + "}\n"
						+ "\tElement at bucket " + pos + ": "
						+ "{" + currEntry.key + ","+ currEntry.value + "}\n"
						+ "------"						
					);
                    */
					pos = (pos+1) % m;
				}
			}
		}

	}
	
	/**
	 * Looks for an element in the hash, using the key part for the 
	 * search. If the element is found, the associated value is returned. 
	 * Otherwise, an exception is thrown. 
	 * 
	 * @param key Key of the element, used to do the search. 
	 * @return The value of the element searched, if it exists in the 
	 * hash table. 
	 */
	public V search(K key) throws ElementNotFoundException {
		for (int i = 0; i < m; i++) {
			if(table[i] != null){
				if(table[i].key.equals(key)) return table[i].value;
			}
		}
		throw new ElementNotFoundException("Element not found.");
	}

	/**
	 * Indicates how many entries the hash table currently holds (n). 
	 * 
	 * @return - Number of elements currently stored in the hash table. 
	 */
	public int size(){
		return n;
	}

	/**
	 * String representation of the hash table. The format is the bucket
	 * number, followd by either "null" if the bucket is empty, or the 
	 * TableEntry itself otherwise. 
	 */
	public String toString(){
		String str = "";
		for(int i = 0; i < m; i++){
			str += i + ": " + table[i] + "\n";
		}
		return str;
	}
	
	public static void main(String[] args) 
		throws ExistingElementException, FullDictionaryException, 
		ElementNotFoundException {
		PermanentDictionary<Integer, Integer> htable 
			= new LinearOAHashTable(10); 
		//htable.search(10);
		
		for(int i = 0; i < 5; i+=1) htable.insert(i,i);
		htable.insert(7,100);
		System.out.println(htable);
		System.out.println("Search(7) = " + htable.search(7));
		System.out.println("size: " + htable.size());
	}
	
    
    /*
     * Methods for test integration:
     */    
    public K getKeyByBucketId(int i) {
        if (this.table[i] == null) {
            return null;
        } else {
            return this.table[i].key;
        }
    }

    public int getM() {
        return this.m;
    }

}




























