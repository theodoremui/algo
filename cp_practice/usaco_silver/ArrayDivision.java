import java.io.*;
import java.util.*;

public class ArrayDivision {
    static int n, k;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new long[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long lo = 0;
        long hi = 2 * (long) 1e5 * (long) 1e9;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (sumPossible(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        pw.println(lo);
        pw.close();
    }

    static boolean sumPossible(long maxSum) {
        long count = 0;
        long curSum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxSum) {
                return false;
            }
            if (curSum + arr[i] > maxSum) {
                count++;
                curSum = 0;
            }
            curSum += arr[i];
        }
        if (curSum > 0) {
            count++;
        }
        return count <= k;
    }
}