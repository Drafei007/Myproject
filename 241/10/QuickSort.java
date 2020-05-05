package week10;

/**
 *  A quick sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Travis
 */
public class QuickSort extends Sorter {
    
    /**
     *  Create a new QuickSort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public QuickSort(Integer[] nums) {
        super(nums);
    }
    
    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using quick sort.
     */
    public void sortNums() {
        quickSort(0, nums.length-1);
    }
    
    /**
     *  Implements quicksort, by choosing a pivot point from the array.
     *  @param left first index position that starts as the pivot.
     *  @param right index position next to left.
     */
    public void quickSort(int left, int right){
        if (left < right){
            int p = partition(left, right);
            quickSort(left, p);
            quickSort(p+1, right);
        }
    }
    
    /**
     *  Partition methods sorting through the use of a pivot, and sorting
     *  either side of that pivot.
     *  @param left first index position that starts as the pivot.
     *  @param right index position next to left.
     *  @return hole that represents the empty index position.
     */
    private int partition(int left, int right){
        int pivot = nums[left];
        int hole = left;
        i = left+1;
        j = right;
        while (true){
            while (j > hole && nums[j] >= pivot){
                j--;
            }
            if (j == hole){
                break;
            }
            nums[hole] = nums[j];
            hole = j;
            while (i < hole && nums[i] < pivot){
                i++;
            }
            if (i == hole){
                break;
            }
            nums[hole] = nums[i];
            hole = i;
            
        }
        ++comparisons;
        update();
        nums[hole] = pivot;
        return hole;
    }
    
}









