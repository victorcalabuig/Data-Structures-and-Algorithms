package P4;

/**
 * This class is used to store the execution statistics of the sorting 
 * algorithms in the Sorting class.
 * @author victor
 *
 */
public class SortingStats {
	private int size; 
	private long steps;
	private float sizeStepsRatio; //steps / size
	private long execTime;
	
	//Getters
	public int size() {
		return size;
	}
	
	public long steps() {
		return steps;
	}
	
	public float sizeStepsRatio() {
		return sizeStepsRatio;
	}
	
	public float execTime() {
		return execTime;
	}
	
	/**
	 * Used to increment step count from the sorting algorithm.
	 */
	public void addStep() {
		steps++;
	}
	
	/**
	 * This method saves the execution stats of the sorting algorithm when 
	 * it finishes (it is called at the end of the algorithm). 
	 * @param size Size of the array on which the algorithm was executed.
	 * @param timeStart Time in nanoseconds of the JVM when the algorithm started.
	 * @param timeEnd Time in nanoseconds of the JVM when the algorithm ended.
	 */
	public void statsAnnotation(int size, long timeStart, long timeEnd)
	{
		this.size = size;
		sizeStepsRatio = (float)steps/size;
		execTime = (timeEnd - timeStart);
	}
	
	/**
	 * Resets the stats to 0 before a new algorithm is executed.
	 */
	public void reset()
	{
		size = 0;
		steps = 0;
		sizeStepsRatio = 0;
		execTime = 0;
	}
	
	
}
