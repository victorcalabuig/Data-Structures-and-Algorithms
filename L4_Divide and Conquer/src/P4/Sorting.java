package P4;

import java.util.Arrays;

public class Sorting {
	
	/**
	 * Used to store the execution stats of the algorithm. 
	 */
	public  static  SortingStats  stats = new SortingStats();
	
	public  static  <E extends  Comparable <E>> void  selectionSort(E[] v) 
	{
		stats.reset();
		long timeStart = System.nanoTime();
		for(int i = 0; i < v.length-1; i++) {
			int min = i;
			for(int j = i+1; j < v.length; j++) {
				if(v[min].compareTo(v[j]) > 0) min = j;
				stats.addStep();
			}
			E aux = v[i]; //this can be done in function to reuse code
			v[i] = v[min];
			v[min] = aux;	
		}
		long timeEnd = System.nanoTime();
		stats.statsAnnotation(v.length, timeStart, timeEnd);
	}
	
	public  static  <E extends  Comparable <E>> void  mergeSort(E[] v) 
	{
		stats.reset();
		long timeStart = System.nanoTime();
		
		mergeSort(v, 0, v.length-1);
		
		long timeEnd = System.nanoTime();
		stats.statsAnnotation(v.length, timeStart, timeEnd);
	}
	
	public static <E extends Comparable<E>> void mergeSort(E[] v, int start, int end)
	{
		if (start < end)
		{
			int mid = (start + end) / 2;
			
			mergeSort(v, start, mid);
			mergeSort(v, mid+1, end);
			
			mergeInPlace(v, start, mid, end);
		}
	}
	
        /*
        He sustituido el método merge por el método mergeInPlace(), que realiza lo 
        mismo pero sin crear en cada llamada dos subarrays (con variables start, 
        mid, y end, que indican los rangos de cada subarray en el array original).
        */
        /*
	public static <E extends Comparable<E>> void merge(E[] v, int start,int mid, int end)
	{				
		//Create left and right temporal subarrays
		E L[] = Arrays.copyOfRange(v, start, mid+1);
		E R[] = Arrays.copyOfRange(v, mid+1, end+1);
		
		int l = 0; 		//to iterate through left sub array
		int r = 0; 		//to iterate through right sub array
		int i = start;  //to iterate through original array
		
		while(l < L.length && r < R.length)
		{
			if(L[l].compareTo(R[r]) <= 0) v[i++] = L[l++];
			else v[i++] = R[r++];
			stats.addStep();
		}
		
		while(l < L.length) v[i++] = L[l++];
		while(r < R.length) v[i++] = R[r++];
	}
        */
        
        /**
         * Takes an array and combines two of its subarrays by sorting them. The
         * two subarrays are indicated by the variables start, mid, and end. 
         * @param v Original array
         * @param start First position of the left subarray.
         * @param mid Last position of the left subarray, and previous to the first
         * position of the right subarray.
         * @param end Last position of the right subarray.
         */
        public static <E extends Comparable<E>> void mergeInPlace(E[] v, int start, int mid, int end)
        {
            if(v[mid].compareTo(v[mid+1]) <= 0){ //already sorted
                stats.addStep();
                return; 
            } 
            
            //2 pointers to iterate through left (start) and right (start2) subarray:
            int start2 = mid + 1;
            
            while(start <= mid && start2 <= end)
            {
                if(v[start].compareTo(v[start2]) <= 0) start++; //element in place
                else
                {
                    E save = v[start2]; 
                    int index = start2;
                    while(index != start){ //shift elements between start and start2 to the right.
                        v[index] = v[index-1];
                        index--;
                    }
                    v[start] = save;
                    
                    start2++;
                    mid++;
                    start++;
                }
                stats.addStep();
            }
        }
	
	
	public  static  <E> String  array2str(E[] v) 
	{
		String str = "[";
		for(int i = 0; i < v.length; i++) {
			str += v[i] + ",";
		}
		if (v.length != 0) str = str.substring(0, str.length()-1);
		return str + "]";
	}
	
	public static Integer[] randomArray(int size)
	{
		Integer[] v = new Integer[size];
		for(int i = 0; i < size; i++) v[i] = (int)(Math.random() * size);
		return v;
	}

	
	public static void main(String[] args) {
		//System.out.println("all fine");
		Integer[] v = randomArray(10);
		
		System.out.println(array2str(v));		
		
		mergeSort(v);
		
		System.out.println(array2str(v));		
		System.out.println();		
	}

}
