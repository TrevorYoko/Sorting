
package sort_evaluations;

import java.util.ArrayList;

import javax.sound.sampled.FloatControl.Type;

/**
 * test quick sort just choosing the first value as the pivot. 
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
	 * Name the sort
	 */
	public String name_of_sort()
	{
		return "Quick Sort First Pivot, with insertion cutoff";
	}


}
