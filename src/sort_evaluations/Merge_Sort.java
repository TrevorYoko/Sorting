
package sort_evaluations;

import java.util.ArrayList;

import javax.sound.sampled.FloatControl.Type;

/**
 * This code calls and gives information on Merge Sort
 * 
 * Pseudo Code
 * 1)Test for single element array
 * 2)Cut Array in half
 * 3)Merge Sort the first half
 * 4)Merge Sort the second half
 * 5)Combine both sides
 * 
 * @author Trevor Yokoyama, Ryan Daly
 * @date   Feb. 2nd 2017
 *
 */

public class Merge_Sort<Type extends Comparable<? super Type>> implements Sorter<Type>// implement sorter
{

	/**
	 * If the list is less than 3 elements, use Insertion Sort
	 */
	double switchOff=3;

	public String name_of_sort(){
		return "Merge Sort";
	}

	/**
	 * Merge Sort
	 * 
	 * split array in half
	 * sort left
	 * sort right
	 * combine
	 * 
	 * 
	 * @param array          the values to sort from small to high
	 * @param low            the index of the starting value in the "virtual array"
	 * @param high           the index of the ending value in the "virtual array"
	 * 
	 */
	private void merge_sort( ArrayList<Type> array, ArrayList<Type> auxillary, int low, int high ){
		if((high-low)>switchOff){
			int middle=low+((high-low)/2);
			//Splits the list into two parts, sorts them and combines them
			merge_sort(array,auxillary,low,middle);
			merge_sort(array,auxillary,middle+1,high);
			combine(array,auxillary,low,middle,high);
		}else{
			//If the size of the list is less than 3, use Insertion sort
			Sort_Utils.insertion_sort(array, low, high+1);
		}
	}

	/**
	 * combine the values in array into the auxiliary
	 * 
	 * @param array           - original values (the entire array)
	 * @param auxillary       - spare space 
	 * @param low             - low,mid are the lower array
	 * @param mid             - mid,high are the upper array
	 * @param high
	 * 
	 * combine the sub arrays in the _array_ parameter. use the _auxillary_ parameter for scratch space
	 */

	private void combine( ArrayList<Type> array, ArrayList<Type> auxillary, int low, int mid, int high ){
		//Makes the auxiliary list get part of the original list
		for(int iterator=low;iterator<=high;iterator++){
			auxillary.set(iterator, array.get(iterator));
		}
		int arrayPosition=low;
		int lowPosition=low;
		int midPosition=mid+1;
		//swap the elements until the low element is less than the middle element and the high element is larger than the middle element
		while(lowPosition<=mid && midPosition<=high){
			if((auxillary.get(lowPosition)).compareTo(auxillary.get(midPosition))<=0){
				array.set(arrayPosition, auxillary.get(lowPosition));
				lowPosition++;
			}else{
				array.set(arrayPosition, auxillary.get(midPosition));
				midPosition++;
			}
			arrayPosition++;
		}
		//If the left hand element is less than the middle element, swap them 
		while(lowPosition<=mid){
			array.set(arrayPosition, auxillary.get(lowPosition));;
			lowPosition++;
			arrayPosition++;
		}
		//if the middle element is less than the high element, swap them
		while(midPosition<=high){
			array.set(arrayPosition, auxillary.get(midPosition));;
			midPosition++;
			arrayPosition++;
		}	
	}

	/**
	 * Allow the insertion sort cut off to be changed
	 */
	public void set_constant( double cutoff ){
		switchOff=cutoff;
	}

	/**
	 * sort the array using mergeSort
	 */
	@Override
	public void sort(ArrayList<Type> array )
	{
		// Build the auxiliary array
		ArrayList<Type> auxillary= new ArrayList<>(array);
		// call mergesort 
		merge_sort(array,auxillary,0,array.size()-1);
	}

	/*
	 * @return N*Log(N) is the complexity for mergeSort
	 */
	@Override
	public Complexity_Class get_expected_complexity_class(){
		return Complexity_Class.NlogN;
	}

}
