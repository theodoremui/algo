import java.util.*;
/**
 * This program performs selection sort on an array.
 *
 * @author Theodore Mui
 * @version 2/9
 */
public class SelectionSort
{
    // instance variables - replace the example below with your own
    private ArrayList<Integer> arr;
    /**
     * Constructor for objects of class SelectionSort
     * PostCondition: input array is not changed.
     */
    public SelectionSort(ArrayList<Integer> array)
    {
        //part A
        arr = array;
    }

    /**
     * doSelectionSort
     *
     * @param  none
     * @return the # of times the inner loop runs.
     */
    public int doSelectionSort()
    {
        //part B
        int count = 0, minPos;
        for (int i = 0; i < arr.size() - 1; i++) {
            minPos = i;
            for (int j = i; j < arr.size(); j++) {
                count++;
                if (arr.get(j) < arr.get(minPos)) {
                    minPos = j;
                }
            }
            int temp = arr.get(i);
            arr.set(i, arr.get(minPos));
            arr.set(minPos, temp);
        }
        return count;
    }
    /* Do not change the following method.  
     * I need it for testing.
     */
    public ArrayList<Integer> getArray()
    {
        return arr;
    }
    public static void main(String[] args)
    {
        int[] arr = {8,10,3,2,5,7,1};
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i: arr)
            list.add(i);
            
        System.out.println(list);        //should not have changed.
        SelectionSort s = new SelectionSort(list);
        int count = s.doSelectionSort();
        System.out.println(s.getArray());  //should be sorted.
        System.out.println(count);
    }
}
