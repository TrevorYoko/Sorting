
package sort_evaluations;

import java.util.ArrayList;

/**
 * This code is an abstract base class for all versions of quicksort.
 * 
 * Pseudo Code
 * 1)Grab a pivot
 * 2)Cut Array in half, one half is elements less than pivot and the otehr is elements more than pivot
 * 3)Sort the lists into smaller lists
 * 4)Combine the lists
 * 
 * @author Trevor Yokoyama, Ryan Daly
 * @date   Feb. 2nd 2017
 *
 */

public abstract class Quick_Sort<Type extends Comparable<? super Type>> implements Sorter<Type>

{
	/**
	 * create a field for the insertion sort switchover level
	 */
	protected static double switchOverLevel=2;

	/**
	 *  Choose a Pivot (return it's value in the array)
	 *  Modify array as appropriate (e.g., median of three will move smallest value to front of array)
	 *
	 * @param array - the array of all values (we only sort a sub piece of the array)
	 * @param start - the start position in the (sub) array
	 * @param end   - the end position in the (sub) array
	 * @return the pivot value
	 */
	protected abstract Type choose_pivot( ArrayList<Type> array, int start, int end );

	/**
	 * Given an array, partition the array such that
	 * all the elements lower than or equal to the pivot are on the left,
	 * all the elements greater than the pivot are on the right.
	 * 
	 * @param array   - data data to sort
	 * @param left    - the start index of the sub array (inclusive)
	 * @param right   - the end index of the sub array (inclusive)
	 * 
	 * @return the location of the pivot
	 */

	protected int partition( ArrayList<Type> array, int left, int right )
	{
		Type pivot=array.get(right);
		int index=left-1;
		//Swaps the necessary elements
		//To the left for less than the pivot
		//To the right for more than the pivot
		for(int position=left;position<right;position++){
			if(array.get(position).compareTo(pivot)<=0){
				index++;
				Sorter.swap(array,index,position);
			}
		}
		Sorter.swap(array, index+1, right);
		return index+1;
		
	}

	

			
	

	/**
	 * The actual Quick Sort on an Array routine.
	 * 
	 * Algorithm:
	 *   1) choose a pivot (store in first bucket for convenience)
	 *   2) o) move all elements higher than the pivot to the right side of the array
	 *      o) move all elements lower than the pivot to the left side of the array
	 *   3) put the pivot back between upper and lower group
	 *   4) sort left side
	 *   5) sort right side   (WARNING: don't sort pivot again)
	 * 
	 * @param array - data to be sorted
	 * @param start is the index of the beginning element
	 * @param end is the index of the last element
	 * 
	 * 
	 */
	private void quick_sort( ArrayList<Type> array, int start, int end )
	{
		if(end-start>switchOverLevel){
			choose_pivot(array,start,end);
		// 1) partition array
			int pivot=partition(array,start,end);
		// 2) sort left
			quick_sort(array,start,pivot-1);
		// 3) sort right           (again, don't resort the pivot)
			quick_sort(array,pivot+1,end);
		}else{
		Sort_Utils.insertion_sort(array, start, end+1);
		}

	}

	/**
	 * the sort interface method.
	 * 
	 * call quicksort on the array
	 * 
	 */
	public void sort( ArrayList<Type> array )
	{
		quick_sort(array, 0, array.size() - 1);
	}

	/**
	 * Name the sort
	 */
	public abstract String name_of_sort();

	/**
	 * The constant in this case is the insertion sort cutoff level... always greater than 3
	 */
	public void set_constant( double constant ){
		switchOverLevel=constant;
	}
	
	/**
	 * @return the expected complexity for quick sort 
	 */
	@Override
	public Complexity_Class get_expected_complexity_class(){
		return Complexity_Class.NlogN;
	}




}
