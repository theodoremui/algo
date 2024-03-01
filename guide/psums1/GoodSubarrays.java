import java.io.*;
import java.util.*;

public class GoodSubarrays {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(r.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(r.readLine());
            int[] a = new int[n + 1];
            String s = r.readLine();
            for (int i = 1; i <= n; i++) {
                a[i] = s.charAt(i - 1) - '0';
            }
            int[] pfx = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                pfx[i] = pfx[i - 1] + a[i];
            }
            HashMap<Integer, Long> mp = new HashMap<Integer, Long>();
            for (int i = 0; i <= n; i++) {
                mp.put(pfx[i] - i, mp.getOrDefault(pfx[i] - i, 0L) + 1);
            }
            long ans = 0;
            for (long x : mp.values()) {
                ans += x * (x - 1) / 2;
            }
            pw.println(ans);
        }

        pw.close();
    }
}