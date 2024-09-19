#include <iostream>
#include "sorting_basic.cpp"
#include <time.h>

using namespace std;

int main() {

    srand(time(NULL));

    //Create the Arrays
    int a = 50000;
    int nums1[a];
    int nums2[a];
    int nums3[a];
    int j = a-1;
    int r = 0;
    

    for(int i = 0; i < a-1; i++) {
        r = rand() % a;
        nums1[i] = i + 1; //Generate ascending
        nums2[i] = j + 1; //Generate descending
        nums3[i] = r; //Generate random
        
        j--;
    }

    //Activate Clocks
    clock_t start, end;
    double cpu_time;

    start = clock();

    //Sort the arrays. 

    insertionSort(nums2,0,a-1);

    //Finalize clocks
    end = clock();
    cpu_time = ((double) end - start) / CLOCKS_PER_SEC;

    printf("Time taken to sort %d elements: %lf \n",a,cpu_time);

    return 0;
}