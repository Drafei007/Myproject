package week10;

/**
 *  A merge sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Travis Dai
 */
public class MergeSort extends Sorter {
    
    /** Second array used for merge sorting. */
    private Integer[] tempMergArr;
    
    /**
     * Create a new MergeSort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public MergeSort(Integer[] nums){
        super(nums);// pass nums[] to the superclass Sort
        tempMergArr = new Integer[nums.length];
    }
    
    /**
     * Sort the integers with MergeSort (which are stored in the parent Sorter class).
     */
    public void sortNums() {
        
        mergeSort(0,nums.length-1);
    }
    /**
     *  Implements mergeSort, by spilting the array into half sub arrays.
     *  @param left first index position that starts as the first point.
     *  @param right index position next to left.
     */
    public void mergeSort(int left, int right){
        if (left < right){
            int mid = (left + right)/2;
            mergeSort(left, mid);
            mergeSort(mid+1, right);
            merge(left, mid+1, right);
        }
    }
    /**
     *  Merge method, merges the subarrays back together in lowest to
     *  highest order.
     *  @param left first index position that starts as the initial point.
     *  @param mid index point where separation occurs from.
     *  @param right inxed point next to left.
     */
    public void merge (int left, int mid, int right){
        for (int i = 0; i < nums.length; i++){
            tempMergArr[i] = nums[i];
        }
        i = left;
        j = left;
        int k = mid;
        while (i < mid && k <= right){
            if (tempMergArr[i] < tempMergArr[k]){
                nums[j++] = tempMergArr[i++];
            }else{
                nums[j++] = tempMergArr[k++];
            }
        }
        while (i < mid){
            nums[j++] = tempMergArr[i++];
        }
        while (j <= right){
            nums[j++] = tempMergArr[k++];
        }
        ++comparisons;
        update();
    }
    
}












