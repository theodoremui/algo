import java.io.*;
import java.util.*;

public class CountingHaybales {
    static int n, q;
    static long[] bales;
    static long[][] queries;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter pw = new PrintWriter("haybales.out");
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        bales = new long[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            bales[i] = Long.parseLong(st.nextToken());
        }
        queries = new long[q][2];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(r.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            queries[i][0] = a;
            queries[i][1] = b;
        }
        Arrays.sort(bales);
        for (int i = 0; i < q; i++) {
            pw.println(upperBound(queries[i][1]) - upperBound(queries[i][0] - 1));
        }
        pw.close();
    }

    static int upperBound(long x) {
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (x < bales[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}