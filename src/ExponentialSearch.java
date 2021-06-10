public class ExponentialSearch {

    /**
     * Exponential search procedure with subsequent binary
     * search based on a sorted input array.
     *
     * @param data = The array to be searched, which is always sorted
     * @param element = The element to be searched for
     * @return The position where the element was found, or -1 otherwise
     */

    public int exponentialSearch(int[] data, int element)
    {
        // if the array == null or the array length == 0, no element can be found and therefore we return -1
        if(data == null || data.length == 0) {
            return -1;
        }

        // check if element is found at the first position of the array
        if(data[0] == element) {
            return 0;
        }

        // case if the array length is 1. If yes, we do not need to call the binary search method (because there is nothing to divide & conquer)
        if(data.length == 1) {
            return -1;   // we return -1 because we already checked index 0 for the element at the previous if-statement
        }

        // find the search range for the binary search method
        int i = 1;  // we start at index 1 because we already checked index 0
        while (i < data.length && data[i] <= element) {  // we loop through the array as long as (1)i is not out of the array boundaries, or (2)the element at index[i] is smaller or equal the element we want to find
            i *= 2;
        }

	/* call the binary search method on the search range
	The element is searched between i/2 and min(i, data.length-1). The 'min(i, data.length-1)' is needed to ensure
	that i is not out of the array bounds. */
        return binarySearch(data, element, i/2, Math.min(i, data.length-1));
    }

    /**
     * Binary search method: searches an element within a given (sorted) array
     *
     * @param data = a sorted array
     * @param left = the left boundary (index) of the search interval
     * @param right = the right boundary (index) of the search interval
     * @param element = the search element
     * @return the index of the element (if found)
     * if the element is not found, -1 is returned
     */

    private int binarySearch(int[] data, int element, int left, int right) {

        if(left <= right) {
            /* calculate the middle of the left and right boundary

	    ! we do not calculate the middle by 'middle = (left + right)/2' because this can lead to overflow:
	    for example: if the sum of left and right is greater than the maximum positive int value, the sum overflows
	    to a negative value and the value stays negative when divided by 2, which would throw an ArrayOutOfBoundsException.
	    Therefore the formula left+((right-left)/2) is used for calculating the middle */
		
            int middle = left + ((right - left) / 2);

            // check if element is found at calculated middle
            if (element == data[middle]) {
                return middle;
            }

            // if the element is greater than the element of data[middle], we search for the element in a new search interval (between 'middle+1' and 'right')
            // we need to add 1 to the middle ('middle+1') because an array does not automatically have a middle element (for example arrays with an even number of elements)
            // therefore we add 1 to 'middle' so no index is lost due to roundings
            if(element > data[middle]) {
                return binarySearch(data, element, middle + 1, right);
            }

            // if the element is smaller than the element of data[middle], we search for the element in a new search interval (between 'left' and 'middle-1')
            if (element < data[middle]) {
                return binarySearch(data, element, left, middle - 1);
            }

        }

        // if element is not found, we return -1
        return -1;

    }
}
