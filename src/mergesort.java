public class mergesort {

    /**
     * Sorts the given array via the mergesort algorithm.
     *
     * @param data the array to be sorted
     */

    public void mergesort(int[] data) {

        if(data == null) {
            return;
        }

        if(data.length > 1) {

            int middle = data.length / 2;

            /*-------Dividing the given array in two equal halfs------*/

            // Initializing an array for the left half of the given array and fill it with the values of the left half of the given array
            int[] dataLeft = new int[middle];
            for(int i = 0; i < middle; i++) {
                dataLeft[i] = data[i];
            }

            // Initializing an array for the right half of the given array and fill it with the values of the right half of the given array
            int[] dataRight = new int[data.length - middle];
            for(int i = middle; i < data.length; i++) {
                dataRight[i - middle] = data[i];
            }

            mergesort(dataLeft);
            mergesort(dataRight);


            /*------Sorting and merging the dataLeft and dataRight arrays to one array------*/

            // Initialization of index variables for the following merge of the sub-arrays (dataLeft and dataRight arrays)
            int i = 0;  // index for dataLeft
            int j = 0;  // index for dataRight
            int k = 0;  // index for data

            // Merging and sorting the dataLeft and dataRight to the data-array
            while(i < dataLeft.length && j < dataRight.length) {
                if(dataLeft[i] < dataRight[j]) {
                    data[k] = dataLeft[i];
                    i++;
                } else {
                    data[k] = dataRight[j];
                    j++;
                }
                k++;
            }

            // Assigning the remaining elements to the data-array
            while(i < dataLeft.length) {
                data[k] = dataLeft[i];
                i++;
                k++;
            }
            while(j < dataRight.length) {
                data[k] = dataRight[j];
                j++;
                k++;
            }
        }
    }
}
