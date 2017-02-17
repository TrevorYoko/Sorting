package sort_evaluations;

/**
 * This enum allows us to "tag" sorts with an expected performance
 * and perhaps compute different statistics based on this. 
 * 
 * @author Trevor Yokoyama, Ryan Daly
 * @Date Feb. 2nd 2017
 */

//Returns the necessary complexity for a given sort
//Nsquared for Insertion_Sort
//NlogN for Java_Sort, Merge_Sort, Quick_Sort, Shell_Sort
public enum Complexity_Class
{
	NlogN,  Nsquared
}
