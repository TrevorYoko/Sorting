
package sort_evaluations;

import java.util.ArrayList;

import javax.sound.sampled.FloatControl.Type;

/**
 * @author H. James de St. Germain
 * @date Spring 2017
 * 
 *       regular merge sort
 */
public class Merge_Sort<Type extends Comparable<? super Type>> implements Sorter<Type>// implement sorter
{

	/**
	 * FIXME: have a value for switching over to insertion sort
	 */
	double switchOff=1;

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
			merge_sort(array,auxillary,low,middle);
			merge_sort(array,auxillary,middle+1,high);
			combine(array,auxillary,low,middle,high);
		}else{
			Sort_Utils.insertion_sort(array, low, high);
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
		for(int iterator=low;iterator<high;iterator++){
			auxillary.set(iterator, array.get(iterator));
		}
		int arrayPosition=low;
		int lowPosition=low;
		int midPosition=mid+1;
		while(lowPosition<mid && midPosition<high){
			if((auxillary.get(lowPosition)).compareTo(auxillary.get(midPosition))<0){
				array.set(arrayPosition, auxillary.get(lowPosition));
				lowPosition++;
			}else{
				array.set(arrayPosition, auxillary.get(midPosition));
				midPosition++;
			}
			arrayPosition++;
		}
		if(lowPosition==mid){
			while(midPosition<high){
				array.set(arrayPosition, auxillary.get(midPosition));
				midPosition++;
				arrayPosition++;
			}
		}else if(midPosition==high){
			while(lowPosition<mid){
				array.set(arrayPosition, auxillary.get(lowPosition));;
				lowPosition++;
				arrayPosition++;
			}
		}
		
	}

	/**
	 * Allow the insertion sort cut off to be changed
	 */
	public void set_constant( double cutoff ){
		switchOff=cutoff;
	}

	/**
	 * sort the array
	 */
	@Override
	public void sort(ArrayList<Type> array )
	{
		// Build the auxiliary array
		ArrayList<Type> auxillary= new ArrayList<>();
		// call mergesort 
		merge_sort(array,auxillary,0,array.size());
	}

	@Override
	public Complexity_Class get_expected_complexity_class(){
		return Complexity_Class.NlogN;
	}

}
