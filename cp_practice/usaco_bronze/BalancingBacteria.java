import java.io.*;
import java.util.*;

public class BalancingBacteria {
    static int n;

    static long[] diff(long[] a) {
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
            if (i > 0) {
                b[i] -= a[i - 1];
            }
        }
        return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        n = Integer.parseInt(r.readLine());
        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        a = diff(diff(a));
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(a[i]);
        }
        pw.println(ans);
        pw.close();
    }
}