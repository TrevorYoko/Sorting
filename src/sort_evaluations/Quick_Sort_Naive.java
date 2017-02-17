
package sort_evaluations;

import java.util.ArrayList;

import javax.lang.model.element.QualifiedNameable;

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
public class Quick_Sort_Naive<Type extends Comparable<? super Type>> extends Quick_Sort<Type>
{

	/**
	 * Chooses the Pivot as being the median of the first, middle and last elements of the list
	 */
	@Override
	protected Type choose_pivot( ArrayList<Type> array, int start, int end )
	{
		//return array.get(0);
		return median_of_three( array );
	}

	/**
	 * Median of Three (choose the middle element position)
	 * 
	 * @return returns the value of the middle element of the array list
	 */
	private Type median_of_three( ArrayList<Type> array )
	{
		if(array.get(0).compareTo(array.get((array.size()-1)/2))>0){
			Sorter.swap(array, 0, (array.size()-1)/2);
		}
		if(array.get(0).compareTo(array.get(array.size()-1))>0){
			Sorter.swap(array, 0, array.size()-1);
		}
		if(array.get((array.size()-1)/2).compareTo(array.get(array.size()-1))>0){
			Sorter.swap(array, array.size()-1, (array.size()-1)/2);
		}
		return array.get((array.size()-1)/2);
	}

	/**
	 * A "Naive" implementation of Quick Sort which uses extra memory
	 * 
	 * Algorithm:
	 * if array small enough, insertion sort it
	 * choose a pivot element (using Median of 3)
	 * put all the small elements in one array
	 * put all the large elements in one array
	 * put all the pivot elements in one array
	 * 
	 * quicksort large
	 * quicksort small
	 * 
	 * put small + pivots + larg back into array
	 */
	public void quick_sort_naive( ArrayList<Type> array )
	{
		/*
		 * Base Case
		 */
		if (array.size() <= Quick_Sort.switchOverLevel)
		{
			Sort_Utils.insertion_sort(array, 0, array.size());
			return;
		}

		/*
		 * Some extra storage to make things easier
		 */
		ArrayList<Type> small_elements = new ArrayList<Type>();
		ArrayList<Type> large_elements = new ArrayList<Type>();
		ArrayList<Type> pivots = new ArrayList<Type>();

		/*
		 * Partition the list into three (small, pivot, large) lists
		 */
		Type pivot_value = this.median_of_three(array);

		for (int i = 0; i < array.size(); i++)
		{
			if (array.get(i).compareTo(pivot_value) < 0)
			{
				small_elements.add(array.get(i));
			}
			else if (array.get(i).equals((pivot_value)))
			{
				pivots.add(array.get(i));
			}
			else
			{
				large_elements.add(array.get(i));
			}
		}

		/*
		 * Quick Sort each half
		 */
		quick_sort_naive(small_elements);
		quick_sort_naive(large_elements);

		/*
		 * Put back together
		 */
		array.clear();
		array.addAll(small_elements);
		array.addAll(pivots);
		array.addAll(large_elements);

	}

	/**
	 * Name of Sort_Tester (Quick Sort, Naive)
	 */
	public String name_of_sort()
	{
		return "Quick Sort Naive (Cutoff: "+ Quick_Sort.switchOverLevel + ")";
	}

	/**
	 * Convert the Type[] array into an array list and
	 * then call the appropriate sort routine!
	 * 
	 * @param array
	 *            the array of data to sort from small to large
	 */
	public void sort( ArrayList<Type> array )
	{
		quick_sort_naive(array);
	}

}
