import java.io.*;
import java.util.*;

public class CellularNetwork {
    static int n, m;
    static long[] cities, towers;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cities = new long[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            cities[i] = Long.parseLong(st.nextToken());
        }
        towers = new long[m];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < m; i++) {
            towers[i] = Long.parseLong(st.nextToken());
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int upper = upperBound(cities[i]);
            int lower = upper - 1;
            long dist;
            if (lower < 0) {
                dist = towers[upper] - cities[i];
            } else if (upper >= m) {
                dist = cities[i] - towers[lower];
            } else {
                dist = Math.min(towers[upper] - cities[i], cities[i] - towers[lower]);
            }
            ans = Math.max(ans, dist);
        }
        pw.println(ans);
        pw.close();
    }

    static int upperBound(long x) {
        int lo = 0, hi = m, mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (x < towers[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}