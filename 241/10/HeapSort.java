package week10;

/**
 *  A heap sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Travis
 */
public class HeapSort extends Sorter {
    /**
     *  Code value indicating that no larger child of a node was found.
     */
    static final int NO_LARGER_CHILD = -1;
    /**
     *  Create a new HeapSort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public HeapSort(Integer[] nums) {
        super(nums);
    }
    
    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using heap sort.
     */
    public void sortNums() {
        heapify();
        for (int i = nums.length-1; i > 0; i--){
            swap(0, i);
            comparisons++;
            siftDown(0, i);
        }
        
    }
    /**
     *  Swaps two items in an array of objects called nums.
     *
     * @param x represents first index to swap.
     * @param y represents index to swap x with.
     *
     */
    private void swap(int x, int y) {
        // int i, j, and nums[] are all protected datafields in the
        // superclass Sort so we can use them without declaring them
        i = x;
        j = y;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        update();
    }
    
    /**
     *  Turn this into a heap by sifting down each value that isn't
     *  already a leaf.
     */
    private void heapify() {
        for (int i = nums.length/2-1; i >= 0; i--){
            siftDown(i, nums.length);
        }
        
    }
    
    /**
     *  Move the value at index i down in the heap to its correct
     *  place by continually swapping it with its largest child that
     *  is bigger than it.
     *
     * @param i the index of the value to be sifted down in the heap.
     * @param size the size of the current heap (will be smaller than
     *        array length as heap sort is performed).
     */
    private void siftDown(int i, int size) {
        while (true){
            int largest = getLargerChildIndex(i, size);
            if (largest == NO_LARGER_CHILD){
                break;
            }
            swap(i, largest);
            comparisons++;
            i = largest;
        }
    }
    
    /**
     *  Returns the index of the largest child of i, or -1 if i
     *  doesn't have a child larger than itself.
     *
     * @param i index of the parent node.
     * @param size index marking the end of the heap.
     * @return the index of i's largest child that is bigger than i or
     *         -1 if no such child exists.
     */
    private int getLargerChildIndex(int i, int size) {
        int l = 2*i+1;
        if (l >= size){
            return NO_LARGER_CHILD;
        }
        int r = 2*i+2;
        if (r >= size || nums[r].compareTo(nums[l]) < 0){
            if (nums[l].compareTo(nums[i]) > 0){
                return l;
            }
            return NO_LARGER_CHILD;
        } else{
            if (nums[r].compareTo(nums[i]) > 0){
                return r;
            }
            return NO_LARGER_CHILD;
        }
        
    }
    
}









