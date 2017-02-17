
package sort_evaluations;

import java.util.ArrayList;

import javax.sound.sampled.FloatControl.Type;

/**
 * This code calls and gives information on Quick Sort with the Pivot being the first element
 * 
 * Pseudo Code
 * 1)Grab a pivot (First element)
 * 2)Cut Array in half, one half is elements less than pivot and the otehr is elements more than pivot
 * 3)Sort the lists into smaller lists
 * 4)Combine the lists
 * 
 * @author Trevor Yokoyama, Ryan Daly
 * @date   Feb. 2nd 2017
 *
 */

public class Quick_Sort_Inplace_First_Pivot<Type extends Comparable<? super Type>> extends Quick_Sort<Type> 
{

	/**
	 * First_Pivot
	 * 
	 * 1) choose the first element in the array as the pivot
	 * 2) Place this element at array[end]
	 * 
	 * @param array          = the array with all the data (we sort a sub piece of the array)
	 * @param start          = index of start of array
	 * @param end            = index of end of array
	 */
	@Override
	protected Type choose_pivot( ArrayList<Type> array, int start, int end )
	{
		Sorter.swap(array, start, end);
		return array.get(end);
	}

	/**
	 * @return The name of this sort (Quick sort, with the first element as the pivot)
	 */
	public String name_of_sort()
	{
		return "Quick Sort First Pivot, with insertion cutoff";
	}


}
