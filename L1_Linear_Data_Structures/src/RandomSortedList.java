package  P1;
public  interface  RandomSortedList <E> {
	void  add(E data);
	void  delete(int  pos) throws  WrongIndexException;
	int  search(E data);
	E get(int pos) throws  WrongIndexException;
	int  size();
	String  toString ();
}
