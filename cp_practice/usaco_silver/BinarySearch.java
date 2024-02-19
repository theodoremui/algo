
/**
 * Description: This program performs a binary search on a range of values.
 * 
 * @author Theodore Mui
 * @version 2/7
 */
public class BinarySearch
{
    // instance variables - replace the example below with your own
    private int answer;
    private int left;
    private int right;

    /**
     * Constructor for objects of class BinarySearch
     * Precondition: max > min
     * Postcondition: answer is set with a random number from min to max (inclusive)
     */
    public BinarySearch(int min, int max)
    {
        // initialize instance variables
       left = min;
       right = max;
       answer = (int) (Math.random() * (max - min) + min);
    }
    /**
     * A public method that sets instance variable answer to the 
     * parameter value.
     * Precondition: searchMin <= ans <= searchMax
     */
    public void setAnswer(int ans)
    {
        answer = ans;
    }
    /**
     * doBinarySearch
     *
     * 
     * @return    the number of guesses performed before finding the answer
     */
    public int doBinarySearch()
    {   
        int count = 0, mid;
        while (left <= right) {
            count++;
            mid = left + (right - left) / 2;
            if (mid == answer) break;
            if (mid < answer) left = mid + 1;
            else right = mid - 1;
        }
        return count;
    }
    public static void main(String[] args)
    {
        //start testing with 10 number, then increase to 
        // a hundred, a thousand, etc.
        BinarySearch b = new BinarySearch(0,99);
        b.setAnswer(87);
        System.out.println("# of searches: " + b.doBinarySearch());
    }
}