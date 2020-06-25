package  P1;

public  interface  List <E> {
	void  insert(int pos , E data) throws  WrongIndexException;
	void  delete(int  pos) throws  WrongIndexException;
	E get(int pos) throws  WrongIndexException;
	int  size();
	void append(E data);
	String  toString ();
}
