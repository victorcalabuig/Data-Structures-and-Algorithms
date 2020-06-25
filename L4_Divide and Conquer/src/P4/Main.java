package P4;

import static P4.Sorting.mergeSort;
import static P4.Sorting.selectionSort;
import java.util.Arrays;

/**
 * This class simulates a real user that wants to use the sorting algorithms in
 * the class Sorting. It has several random algorithms available, and executes
 * the sorting algorithms selectionSort and mergeSort on them. Then, it print
 * out to the console the execution stats of each algorithm on each array, using
 * the class SortingStats.
 *
 * @author victor
 *
 */
public class Main {

    /**
     * Number of times to execute each sorting algorithm, in order to measure
     * the average execution time and reduce the variability that the
     * environment adds to this measurement.
     */
    static final int executions = 3;

    /**
     * Internally, time is calculated in nanoseconds. This value is used to
     * convert from nanoseconds to the desired format, by dividing the original
     * value by this value. For example to express in seconds use 10⁹.
     */
    static final double timePrecision = 1000000000;

    /**
     * Random arrays to be sorted out by the algorithms. Uncomment or add more
     * arrays with different sizes if desired.
     */
    private static final Integer[][] arrays = {
        Sorting.randomArray(20000),
        Sorting.randomArray(50000),
        Sorting.randomArray(100000),
        Sorting.randomArray(200000), //Sorting.randomArray(1000000)
    };

    
    private static final Sorter[] algorithms = {
        v -> selectionSort(v), 
        v -> mergeSort(v),
    };
    
    /**
     * Prints the execution statistics of the algorithm, retrieving them from
     * the SortingStats object.
     *
     * @param stats Reference to the object where the stats are stored.
     */
    public static void printStats(SortingStats stats, float time) {
        System.out.printf("%-20d", stats.steps());
        System.out.printf("%-10.0f", stats.sizeStepsRatio());
        System.out.printf("%-10.4f", time / timePrecision); //do several times
        System.out.printf("%-5s", "|");
    }

    public static void main(String[] args) {
        Sorting sorting = new Sorting();

        //Print header of the table
        System.out.printf("%-10s%-5s%20s%-10s%-10s%-5s", "", "|", "SelectSort", "", "", "|");
        System.out.printf("%20s%-10s%-10s%-5s\n", "MergeSort", "", "", "|");
        System.out.printf("%-10s%-5s%-20s%-10s%-10s%-5s", "Size", "|", "Steps", "Ratio", "Time(s)", "|");
        System.out.printf("%-20s%-10s%-10s%-5s\n", "Steps", "Ratio", "Time(s)", "|");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        for(Integer[] array : arrays) //For each array in arrays[]:
        {
            System.out.printf("%-10d%-5s", array.length, "|");
            for(Sorter sorter: algorithms) //execute each sorting algorithm on the array
            {
                float time = 0;
                for (int n = 0; n < executions; n++) { 
                    Integer[] copy = Arrays.copyOf(array, array.length);
                    sorter.run(copy); //execute sorting 
                    time += sorting.stats.execTime();
                }
                time = time / executions; //calculate average time
                printStats(sorting.stats, time); //print SelectionSort stats
            }
            System.out.println();
        }
    }

}
