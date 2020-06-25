package P2;

/**
 * Implements the permanent dicitionary abstract data type through a 
 * hash table that has the ability to expand its number of buckets 
 * dynamically. Collsions are resolved through open adressing. 
 */
public class ExpandableLinearOAHashTable<K,V>  
	extends LinearOAHashTable<K,V> 
	implements PermanentDictionary<K,V> 
{
	public static final int minBUCKETS = 4; //minimum number of buckets
	
	/*
	 * The loading factor at any given point is n / m. The variable 
	 * maxLoad determines the maximum loading factor allowed for the 
	 * hashtable. If a new element to be inserted would make the new 
	 * loading factor bigger than the maxLoad, then the number of 
	 * buckets (m) is increased to not break this rule. 
	 */
	double maxLoad; 
	
	/**
	 * This constructor creates a hashtable with the maximum loading 
	 * factor specified by the user, and the number of buckets specified
	 * by the constant minBuckets. 
	 */
	public ExpandableLinearOAHashTable(double maxLoad){
		super(minBUCKETS);
		this.maxLoad = maxLoad;	
	}
	
	/**
	 * Constructor that allows the user to specify the number of buckets 
	 * that the hashtable has initially.
	 */
	ExpandableLinearOAHashTable(double maxLoad, int m){
		super(m);
		this.maxLoad = maxLoad;	
	}
	
	/**
	 * Increases the number of buckets that the hashtable has. 
	 */
	public void expand() throws ExistingElementException, FullDictionaryException {
		int oldSize = m;
        TableEntry[] oldTable = table; 
		m = (int)(((n+1) / maxLoad + 0.99) + m * 0.2);
		table = new TableEntry[m];
        n = 0;
		for(int i = 0; i < oldSize; i++){
			if(oldTable[i] != null){
                K key = (K)oldTable[i].key;
                V value = (V)oldTable[i].value;
				insertInternal(key, value);
			}
		}
	}
	
	/**
	 * Inserts an element into the hashtable. If the new element to be 
	 * inserted makes the current loading factor (n/m) bigger than the 
	 * maximum loading factor specified by maxLoad, then the table is 
	 * expanded calling the expand() method. 
	 */
	@Override
	public void insert(K key, V value) throws ExistingElementException,
	      FullDictionaryException 
	{
		double futureLoad = (double)(n+1)/m;
		if(futureLoad >= maxLoad) {
			expand();
		}
		insertInternal(key, value);
	}
	
	
	
	
	
	
	
	public static void main(String[] args)
		throws ExistingElementException, FullDictionaryException, 
		ElementNotFoundException
	{
		ExpandableLinearOAHashTable<String, Integer> etable 
			= new ExpandableLinearOAHashTable<String, Integer>(0.8);
			
			etable.insert("primero", 1);
			etable.insert("segundo", 2);
			etable.insert("tercero", 3);
                        
			etable.insert("cuarto", 4);
                        System.out.println(etable);
                        /*
			etable.insert("quinto", 5);                   
			etable.insert("sexto", 6);
                        System.out.println(etable);
			etable.insert("septimo", 7);
			etable.insert("octavo", 7);
			etable.insert("noveno", 7);
			etable.insert("decimo", 7);
			etable.insert("undecimo", 7);
			etable.insert("duodecimo", 7);
			etable.insert("decimotercero", 7);
			etable.insert("decimocuarto", 7);
			etable.insert("decimoquinto", 7);
			etable.insert("decimosexto", 7);
                        */

                        
                        //System.out.println(etable);
                        //System.out.println(etable.search("primero"));
			
	}
}








