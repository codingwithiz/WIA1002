import java.util.Arrays;

public class L10Q1 {
    public static void main(String[] args) {
        int[] arr = {45, 7, 2, 8, 19, 3};
        selectionSortSmallest(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{45, 7, 2, 8, 19, 3};
        selectionSortLargest(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{10, 34, 2, 56, 7, 67, 88, 42};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSortSmallest(int[]arr){
        for(int i = 0; i< arr.length-1; i++){
            int min = i;
            for(int j = i+1; j<arr.length ; j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void selectionSortLargest(int[]arr){
        for(int i = 0; i< arr.length-1; i++){
            int max = i;
            for(int j = i+1; j<arr.length ; j++){
                if(arr[j]>arr[max]){
                    max = j;
                }
            }
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[]arr){
        for(int i = 1; i<arr.length; i++){
            int currentElement = arr[i];
            int k;
            for(k = i-1; k>=0 && arr[k]>currentElement; k--){
                arr[k+1] = arr[k];
            }
            arr[k+1] = currentElement;
        }
    }
}