import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergesortTest {

    private Random random = new Random(System.currentTimeMillis());

    private Mergesort mgsort = new Mergesort();

    private int TEST_NUM_SMALL = 100;        // Number of test cases (small)
    private int TEST_NUM_LARGE = 100000;     // Number of test cases (large)
    private int SMALL_ARRAY = 5000;          // Array size (small)
    private int LARGE_ARRAY = 500000;        // Array size (large)


    @Test
    public void testMergeSortSmall() {
        for(int i = 0; i < TEST_NUM_SMALL; ++i) {
            int[] test = getRandomArray(SMALL_ARRAY);
            int[] copy = Arrays.copyOf(test, test.length);
            mgsort.mergesort(test);
            Arrays.sort(copy);
            assertArrayEquals(copy, test);
        }
    }

    @Test
    public void testMergeSortLarge() {
        for(int i = 0; i < TEST_NUM_SMALL; ++i) {
            int[] test = getRandomArray(LARGE_ARRAY);
            int[] copy = Arrays.copyOf(test, test.length);
            mgsort.mergesort(test);
            Arrays.sort(copy);
            assertArrayEquals(copy, test);
        }
    }


    /**
     * Generates a random array of the defined size
     * @param size = the size of the array
     * @return = a random array
     */
    private int[] getRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; ++i)
            array[i] = Math.abs(random.nextInt(2 * size));
        return array;
    }
}
