/**
 * 
 */
package sort_evaluations;

import java.util.ArrayList;

/**
 * This code calls Sort_Utils.Java to test and time all of the different sort algoruthms
 * 
 * @author Trevor Yokoyama, Ryan Daly
 * @date   Feb. 2nd 2017
 *
 */

public class Main
{

	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		ArrayList<Sorter<Integer>> sort_methods = new ArrayList<>();
		sort_methods.add(new Insertion_Sort<Integer>());
		sort_methods.add(new Java_Sort<Integer>());
		sort_methods.add(new Merge_Sort<Integer>());
		sort_methods.add(new Quick_Sort_Inplace_First_Pivot<Integer>());
		sort_methods.add(new Quick_Sort_Inplace_M3<Integer>());
		sort_methods.add(new Quick_Sort_Inplace_Random_Pivot<Integer>());
		sort_methods.add(new Quick_Sort_Naive<Integer>());
		sort_methods.add(new Shell_Sort<Integer>());
		
		//Iterates through all of the sorts and increases the number of elements by 10,000 each call
		//It looks to see the run time and complexity of the algorithms
		for(Sorter<Integer> sorter : sort_methods) {
			new Sort_Utils().test_and_time(sorter, 10000, 10000, 1000000, 600);
		}
		
	}

}
