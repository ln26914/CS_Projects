/**
 *Implemention of selected sorting algorithms
 *@file sorting.cpp
 */
#include "sorting.h"
#include <iostream>
using namespace std;

/**
 *Implement the insertionSort algorithm correctly
 */
void insertionSort(int array[], int lowindex, int highindex, bool reversed)
{
	int i, j, key;

	//Non-Reversed: Sort using Insertion Sort
		for(i = lowindex; i < highindex; i++) {
			key = array[i];
			j = i-1;
			while(j >= 0 && array[j] > key) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}

	//Reversed: Reverse the sorted array in descending order
	if(reversed) {
		int l = (highindex - lowindex) / 2;
		i = lowindex, j = highindex;

		for(i = 0; i < l; i++) {
			swap(array[i],array[j]);
			i++, j--;
		}
	}
}

/**
 *@brief Implementation of the partition function used by quick sort
 *
 */
int partition(int array[], int lowindex, int highindex, bool reversed)
{
 
    int pivot = array[lowindex];
 
    int count = highindex;
 
    // Giving pivot element its correct position
    int pivotIndex = lowindex + count;

    swap(array[pivotIndex], array[lowindex]);
 
    // Sorting left and right parts of the pivot element
    int i = lowindex, j = highindex;
 
    while (i < pivotIndex && j > pivotIndex) {
 
        while (array[i] <= pivot) {
            i++;
        }
 
        while (array[j] > pivot) {
            j--;
        }
 
        if (i < pivotIndex && j > pivotIndex) {
            swap(array[i++], array[j--]);
        }
    }
 
    return pivotIndex;
}

/**
 *Implement the quickSort algorithm correctly
 */

 //This almost certainly won't work
void quickSort(int array[], int lowindex, int highindex, bool reversed)
{
	if (lowindex >= highindex)
		return;
	
	//Quick Sort
	int p = partition(array,lowindex,highindex,reversed);
	
	quickSort(array,lowindex,p-1,reversed);
	quickSort(array,p+1,highindex,reversed);

}

