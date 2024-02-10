// package silver;

import java.io.*;
import java.util.*;

public class ConcertTickets {
    static TreeMap<Long, Long> multiset = new TreeMap<Long, Long>();

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] h = new long[n];
        long[] t = new long[m];

        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            h[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < m; i++) {
            t[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < n; i++)  { add(h[i]); }
        for (int i = 0; i < m; i++) {
            if (multiset.floorKey(t[i]) != null) {
                pw.println(multiset.floorKey(t[i]));
                remove(multiset.floorKey(t[i]));
            } else {
                pw.println(-1);
            }
        }

        pw.close();
    }

    static void add(long x) {
        if (multiset.containsKey(x)) {
            multiset.put(x, multiset.get(x) + 1);
        } else {
            multiset.put(x, (long) 1);
        }
    }

    static void remove(long x) {
        multiset.put(x, multiset.get(x) - 1);
        if(multiset.get(x) == 0) { multiset.remove(x); }
    }
}
