
package sort_evaluations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * This code contains all the necessary information for Java_Sort(TimSort, a sort of merge sort)
 * Pseudo Code
 * 1) Split the list in half
 * 2) Sort the sides
 * 3) Merge them back together
 * 
 * @author Trevor Yokoyama, Ryan Daly
 * @date   Feb. 2nd 2017
 *
 */
public class Java_Sort<Type extends Comparable<? super Type>> implements Sorter<Type>
{

	/**
	 *	Sorts the Array by using TimSort
	 */
	public void sort( ArrayList<Type> array ){
		Collections.sort(array);
	}

	/**
	 * @return The name of the sort, Java Sort
	 */
	public String name_of_sort(){
		return "Java's Sort";
	}

	/**
	 * Prints out that you are unable to modify Java's default sort
	 */
	public void set_constant( double constant ){
		System.out.println("cant modify Java's sort algorithm");
	}


	/**
	 * @return The complexity of the algorithm, N * LOG(N)
	 */
	@Override
	public Complexity_Class get_expected_complexity_class(){
		return Complexity_Class.NlogN;
	}
	

}
