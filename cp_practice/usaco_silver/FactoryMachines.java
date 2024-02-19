import java.io.*;
import java.util.*;

public class FactoryMachines {
    static int n;
    static int t;
    static int[] k;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            k[i] = Integer.parseInt(st.nextToken());
        }
        pw.println(findValid(0, (long) 1e18));
        pw.close();
    }

    static long findValid(long lo, long hi) {
        long ans = 0;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += mid / k[i];
                if (sum >= t) {
                    break;
                }
            }
            if (sum >= t) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}