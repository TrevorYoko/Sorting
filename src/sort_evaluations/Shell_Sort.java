package sort_evaluations;

import java.util.ArrayList;
/**
 * This code calls and gives information on Shell Sort
 * 
 * Pseudo Code
 * 1)Start with the largest gap
 * 2)Perform an insertion sort with a gap
 * 3)Keep adding elements until there is a gap sorted array
 * 4)Shift the elements until they are sorted and no longer gap sorted
 * 
 * @author Trevor Yokoyama, Ryan Daly
 * @date   Feb. 2nd 2017
 *
 */
public class Shell_Sort<Type extends Comparable<? super Type>> implements Sorter<Type>
{

	/**
	 * the choice of "gap" for shell sort
	 */
	double GAP = 2.2;

	/**
	 * The name of the sort
	 */
	public String name_of_sort()
	{
		return "Shell Sort using a gap of " + this.GAP;
	}

	/**
	 * For details on Shell Sort, see the Text or google
	 * 
	 * 
	 * @param array
	 *            the values to sort from small to high
	 */
	private void shell_sort( ArrayList<Type> array )
	{
		int gap = array.size() / 2;

		while (gap > 0)
		{
			for (int i = gap; i < array.size(); i++)
			{
				Type tmp = array.get(i);
				int j = i;
				while (j >= gap && tmp.compareTo(array.get(j - gap)) < 0)
				{
					//Swap. 
					Sorter.swap(array, j, j-gap);

					j -= gap;
				}
			}

			// change the gap value to a smaller value
			if (gap == 2)
			{
				gap = 1;
			}
			else
			{
				gap = (int) (gap / this.GAP);
			}
		}

	}

	/**
	 * Allow the gap to be changed more time testing
	 */
	public void set_constant( double cutoff )
	{
		this.GAP = cutoff;
	}

	/**
	 *  sort the array
	 */
	@Override
	public void sort( ArrayList<Type> array )
	{
		shell_sort(array);
	}

	@Override
	public Complexity_Class get_expected_complexity_class()
	{
		return Complexity_Class.NlogN;
	}

}