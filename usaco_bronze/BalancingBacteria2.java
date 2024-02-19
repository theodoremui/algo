import java.io.*;
import java.util.*;

public class BalancingBacteria2 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = Integer.parseInt(r.readLine());
        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        long adjustment = 0;
        long increase = 0;
        long decrease = 0;
        for (int i = 0; i < n; i++) {
            a[i] += adjustment;
            if (a[i] < 0) {
                increase = increase - a[i];
            } else {
                decrease = decrease + a[i];
            }
            adjustment = adjustment + increase - decrease - a[i];
        }
        pw.println(increase + decrease);
        pw.close();
    }
}