package sort_evaluations;

import java.net.Proxy.Type;
import java.util.ArrayList;

/**
 * This code calls and gives information on Insertion sort
 * 
 * Pseudo Code
 * 1) Checks to see if the list is bigger than 1 element
 * 2)Iterates through the loop
 * 3)while going through the loop, Iterate through the loop
 * 4)if one element ,that is to the right of another element, is smaller than switch the elements
 * 
 * @author Trevor Yokoyama, Ryan Daly
 * @date   Feb. 2nd 2017
 *
 */

public class Insertion_Sort<Type extends Comparable<? super Type>> implements Sorter<Type> // make generic and implement Sorter 
{

	/**
	 * Returns the name of the sort
	 */
	public String name_of_sort(){
		return "Insertion Sort";
	}

	/**
	 * No affect on insertion sort
	 */
	public void set_constant( double constant ){
		System.out.println("This is ignored");
	}

	/**
	 * Calls Insertion sort on the Given array from the Sort_Utils.Java file
	 */
	public void sort( ArrayList<Type> array ){
		Sort_Utils.insertion_sort(array, 0, array.size());
	}

	/**
	 * @return the expected complexity of this algorithm
	 */
	@Override
	public Complexity_Class get_expected_complexity_class(){
		return Complexity_Class.Nsquared;
	}


}
