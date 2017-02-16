
package sort_evaluations;

import java.util.ArrayList;

/**
 * 
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
		int position=(int)Math.random()*(end-start);
		Sorter.swap(array, position, end);
		return array.get(end);
	}

	/**
	 * Name the sort
	 */
	public String name_of_sort()
	{
		return "Quicksort random pivot";
	}


}
