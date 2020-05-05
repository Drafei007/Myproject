package week10;

/**
 *  A silly sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Travis Dai
 */
public class SelectionSort extends Sorter {
    
    /**
     * Create a new SelectionSort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public SelectionSort(Integer[] nums){
        super(nums);// pass nums[] to the superclass Sort
    }
    
    /**
     * Sort the integers with selectsort
     * (which are stored in the parent Sorter class).
     */
    public void sortNums() {
        // int i, j, comparisons, and nums[] are all protected datafields in
        // the superclass Sort so we can use them without declaring them
        comparisons = 0;
        int temp;
        for (i = 0; i < nums.length; i++) {
            for (j = i+1; j < nums.length; j++) {
                if (++comparisons > 0 && nums[i] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                update();
            }
        }
    }
    
}





