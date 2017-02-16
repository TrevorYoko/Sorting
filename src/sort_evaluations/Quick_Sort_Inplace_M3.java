
package sort_evaluations;

import java.util.ArrayList;

/**
 *  use the median of three technique to compare vs random pivot selection, etc.
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
		Type first=array.get(start);
		Type middle=array.get((end-start)/2);
		Type last=array.get(end);
		if(first.compareTo(middle)>0){
			Sorter.swap(array, start, (end-start)/2);
		}
		if(first.compareTo(last)>0){
			Sorter.swap(array, start, end);
		}
		if(middle.compareTo(last)>0){
			Sorter.swap(array, end, (end-start)/2);
		}
		Sorter.swap(array, (end-start)/2, end-1);
		Sorter.swap(array, end-1, end);
		return array.get(end);
	}


	/**
	 * Name the sort
	 */
	public String name_of_sort()
	{
		return "Quick sort M3 with insertion cutover cost";
	}


}
