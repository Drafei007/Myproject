package week09;

/**
 *  A silly sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Travis Dai
 */
public class InsertionSort extends Sorter {
    
    /**
     * Create a new SelectionSort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public InsertionSort(Integer[] nums){
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
        for (i = 1; i < nums.length; i++) {
            temp = nums[i];
            j= i - 1;
            while(j>=0 && ++comparisons> 0 && nums[j]> temp){
                nums[j+1] = nums[j];
                j=j-1;
                
            }
            nums[j+1]=temp;
            update();
            
        }
    }
    
}











