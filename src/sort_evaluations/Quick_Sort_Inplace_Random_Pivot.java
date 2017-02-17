
package sort_evaluations;

import java.util.ArrayList;

/**
 * This code calls and gives information on Quick Sort with the Pivot being a random element
 * 
 * Pseudo Code
 * 1)Grab a pivot(Random element)
 * 2)Cut Array in half, one half is elements less than pivot and the otehr is elements more than pivot
 * 3)Sort the lists into smaller lists
 * 4)Combine the lists
 * 
 * @author Trevor Yokoyama, Ryan Daly
 * @date   Feb. 2nd 2017
 *
 */
public class Quick_Sort_Inplace_Random_Pivot<Type extends Comparable<? super Type>> extends Quick_Sort<Type>
{

	/**
	 * Random_Pivot
	 * 
	 * 1) Choose an element at random in the array and use it as pivot
	 * 2) Place this element at array[end]
	 * 
	 * @param array     = the array with all the data (we sort a sub piece of the array)
	 * @param start      = index of start of array
	 * @param end        = index of end of array
	 */
	protected Type choose_pivot( ArrayList<Type> array, int start, int end )
	{
		int position=start+(int)Math.random()*(end-start);
		Sorter.swap(array, position, end);
		return array.get(end);
	}

	/**
	 * Name the sort(Quicksort with a random element as the pivot)
	 */
	public String name_of_sort()
	{
		return "Quicksort random pivot";
	}


}
