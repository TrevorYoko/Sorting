
package sort_evaluations;

import java.util.ArrayList;

/**
 * This code calls and gives information on Quick Sort with the Pivot being the median of three elements
 * 
 * Pseudo Code
 * 1)Grab a pivot (The median of the first, middle and last elements of the list)
 * 2)Cut Array in half, one half is elements less than pivot and the other is elements more than pivot
 * 3)Sort the lists into smaller lists
 * 4)Combine the lists
 * 
 * @author Trevor Yokoyama, Ryan Daly
 * @date   Feb. 2nd 2017
 *
 */
public class Quick_Sort_Inplace_M3<Type extends Comparable<? super Type>> extends Quick_Sort<Type> 
{

	/**
	 * Median of Three (choose the middle element position)
	 * 
	 * WARNING: this not only chooses the pivot, but modifies the position of the three elements.
	 * 
	 * 1) Choose 3 elements from the array (start, middle, end)
	 * 2) Place the median element at array[end-1]
	 * 3) Place low element at array[start]
	 * 4) Place high element at array[end]
	 * 
	 * You shouldn't call this method when the array is smaller than 3 elements
	 * 
	 * @param array the array with all the data (we sort a sub piece of the array)
	 * @param start  = index of start of array
	 * @param end    = index of end of array
	 */
	protected Type choose_pivot( ArrayList<Type> array, int start, int end )
	{
		if(array.get(start).compareTo(array.get(start+((end-start)/2)))>0){
			Sorter.swap(array, start, start+((end-start)/2));
		}
		if(array.get(start).compareTo(array.get(end))>0){
			Sorter.swap(array, start, end);
		}
		if(array.get(start+((end-start)/2)).compareTo(array.get(end))>0){
			Sorter.swap(array, end, start+((end-start)/2));
		}
		Sorter.swap(array, start+((end-start)/2), end-1);
		Sorter.swap(array, end-1, end);
		return array.get(end);
	}


	/**
	 * Name the sort (Quick sort with the median of 3 elements as the pivot)
	 */
	public String name_of_sort()
	{
		return "Quick sort M3 with insertion cutover cost";
	}


}
