package P4;

/**
 * The purpose of this interface is to create an array of type Sorter[] where 
 * several sorting algorithms will be stored. This array will then be used to 
 * execute all the sorting algorithms stored in it in an iterativa manner. 
 * @author Victor Calabuig
 */
public interface Sorter<E extends Comparable<E>> {
    void run(E[] v);
}
