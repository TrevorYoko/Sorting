
package sort_evaluations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *         FIXME: this code wraps JAVAs arraylist built in sort to see
 *         how it compares with our sorts
 * 
 */
public class Java_Sort<Type extends Comparable<? super Type>> implements Sorter<Type>
{

	/**
	 * FIXME: implement this to sort the array using the arraylist built in sort and natural order comparator
	 */
	public void sort( ArrayList<Type> array ){
		Collections.sort(array);
	}

	/**
	 * FIXME: return the Name the sort (in this case Java's sort)
	 */
	public String name_of_sort(){
		return "Java's Sort";
	}

	/**
	 * FIXME: Nothing to do here. Print a message that you can't modify Java's sort algorithm
	 */
	public void set_constant( double constant ){
		System.out.println("cant modify Java's sort algorithm");
	}


	/**
	 * FIXME: hypothesize what you think javas sort BIG O should be.
	 * @return the expected complexity for javas sorts
	 */
	@Override
	public Complexity_Class get_expected_complexity_class(){
		return Complexity_Class.NlogN;
	}
	

}
