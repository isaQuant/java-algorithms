public class Quicksort {

    /**
     * Sorts the given array from index i1 to index i2 via quicksort algorithm
     * @param arr = the array to be sorted
     * @param begin = the first index
     * @param end = the second index
     */

    public void quicksort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quicksort(arr, begin, partitionIndex-1);
            quicksort(arr, partitionIndex+1, end);
        }
    }
    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;



    }
}
