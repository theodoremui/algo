import java.io.*;
import java.util.*;

public class SubarraySumsII {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        
        long[] a = new long[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        long pSum = 0;
        long ans = 0;
        HashMap<Long, Integer> mp = new HashMap<Long, Integer>();
        mp.put((long) 0, 1);

        for (int i = 0; i < n; i++) {
            pSum += a[i];

            if (mp.containsKey(pSum - x)) {
                 ans += mp.get(pSum - x);
            }

            if (mp.containsKey(pSum)) {
                mp.put(pSum, mp.get(pSum) + 1);
            } else {
                mp.put(pSum, 1);
            }
        }
        pw.println(ans);

        pw.close();
    }
}