import java.io.*;
import java.util.*;

public class MaximumMedian {
    static int n;
    static long k;
    static long[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
        a = new long[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(a);
        pw.println(lastTrue(1, (int)2e9));
        pw.close();
    }

    static boolean medReachable(long x) {
        long count = 0;
        for (int i = (n - 1) / 2; i < n; i++) {
            count += Math.max(0, x - a[i]);
        }
        return count <= k;
    }

    static long lastTrue(int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (medReachable(mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}