import java.io.*;
import java.util.*;

public class Towers {
    static TreeMap<Long, Long> multiset = new TreeMap<Long, Long>();
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = Integer.parseInt(r.readLine());
        long[] blocks = new long[n];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            blocks[i] = Long.parseLong(st.nextToken());
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (multiset.higherKey(blocks[i]) != null) {
                remove(multiset.higherKey(blocks[i]));
            } else {
                count++;
            }
            add(blocks[i]);
        }
        pw.println(count);
        pw.close();
    }

    static void add(long x) {
        if(multiset.containsKey(x)) {
            multiset.put(x, multiset.get(x) + 1);
        } else {
            multiset.put(x, (long) 1);
        }
    }

    static void remove(long x) {
        multiset.put(x, multiset.get(x) - 1);
        if (multiset.get(x) == 0) {
            multiset.remove(x);
        }
    }
}