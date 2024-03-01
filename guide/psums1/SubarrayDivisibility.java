import java.io.*;
import java.util.*;

public class SubarrayDivisibility {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = Integer.parseInt(r.readLine());

        long[] a = new long[n + 1];
        long[] pfx = new long[n + 1];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(st.nextToken());
            pfx[i] = ((pfx[i - 1] + a[i]) % n + n) % n;
        }

        HashMap<Long, Integer> mp = new HashMap<Long, Integer>();
        mp.put((long) 0, 1);
        for (int i = 1; i <= n; i++) {
            if (mp.containsKey(pfx[i])) {
                mp.put(pfx[i], mp.get(pfx[i]) + 1);
            } else {
                mp.put(pfx[i], 1);
            }
        }

        long ans = 0;
        for (Map.Entry<Long, Integer> entry : mp.entrySet()) {
            long m = entry.getValue();
            ans += m * (m - 1) / 2;
        }

        pw.println(ans);
        pw.close();
    }
}