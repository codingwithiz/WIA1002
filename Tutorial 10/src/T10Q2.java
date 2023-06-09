public class T10Q2 {
    /*
     * a. Selection sort
     * Selection sort finds the smallest number in the list and places it first.
     * It then finds the smallest number remaining and places it second, and so on until the array contains a single number.
     * 0) 90 8 7 56 125 237 9 1 653
     * 1) 1 8 7 56 125 237 9 90 653
     * 2) 1 7 8 56 125 237 9 90 653
     * 3) 1 7 8 56 125 237 9 90 653
     * 4) 1 7 8 9 125 237 56 90 653
     * 5) 1 7 8 9 56 237 125 90 653
     * 6) 1 7 8 9 56 90 125 237 653
     * 7) 1 7 8 9 56 90 125 237 653
     * 8) 1 7 8 9 56 90 125 237 653
     *
     * b. Insertion sort
     * Insertion sort sorts the array by repeatedly inserting an unsorted element into a sorted subarray.
     * This process continues until the whole array is sorted.
     * 0) 90 8 7 56 125 237 9 1 653
     * 1) 8 90 7 56 125 237 9 1 653
     * 2) 7 8 90 56 125 237 9 1 653
     * 3) 7 8 56 90 125 237 9 1 653
     * 4) 7 8 56 90 125 237 9 1 653
     * 5) 7 8 56 90 125 237 9 1 653
     * 6) 7 8 9 56 90 125 237 1 653
     * 7) 1 7 8 9 56 90 125 237 653
     * 8) 1 7 8 9 56 90 125 237 653
     *
     * c. Bubble sort
     * Bubble sort makes several passes through the array.
     * On each pass, successive neighboring pairs are compared.
     * If a pair is in decreasing order, its values are swapped.
     * This process continues until all elements are sorted.
     * 0) 90 8 7 56 125 237 9 1 653
     * 1) 8 7 56 90 125 9 1 237 653
     * 2) 7 8 56 90 9 1 125 237 653
     * 3) 7 8 56 9 1 90 125 237 653
     * 4) 7 8 9 1 56 90 125 237 653
     * 5) 7 8 1 9 56 90 125 237 653
     * 6) 7 1 8 9 56 90 125 237 653
     * 7) 1 7 8 9 56 90 125 237 653
     *
     * d. Merge sort
     * Merge sort divides the array into two halves and applies a merge sort on each half recursively.
     * After the two halves are sorted, they are merged.
     * 0)  90 8 7 56 125 237 9 1 653
     * 1)  90 8 7 56 : 125 237 9 1 653
     * 2)  90 8 : 7 56 : 125 237 9 1 653
     * 3)  90 : 8 : 7 56 : 125 237 9 1 653
     * 4)  8 90 : 7 56 : 125 237 9 1 653
     * 5)  8 90 : 7 : 56 : 125 237 9 1 653
     * 6)  8 90 : 7 56 : 125 237 9 1 653
     * 7)  7 8 56 90 : 125 237 9 1 653
     * 8)  7 8 56 90 : 125 237 : 9 1 653
     * 9)  7 8 56 90 : 125 : 237 : 9 1 653
     * 10) 7 8 56 90 : 125 237 : 9 1 653
     * 11) 7 8 56 90 : 125 237 : 9 : 1 653
     * 12) 7 8 56 90 : 125 237 : 9 : 1 653
     * 13) 7 8 56 90 : 125 237 : 9 : 1 : 653
     * 14) 7 8 56 90 : 125 237 : 9 : 1 653
     * 15) 7 8 56 90 : 125 237 : 1 9 653
     * 16) 7 8 56 90 : 1 9 125 237 653
     * 17) 1 7 8 9 56 90 125 237 653
     */
}
