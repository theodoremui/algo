import java.io.*;
import java.util.*;

public class MaximumSubarraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = Integer.parseInt(r.readLine());
        long[] arr = new long[n + 1];
        long[] pfx = new long[n + 1];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            pfx[i] = pfx[i - 1] + arr[i];
        }
        long mn = 0;
        long mx = arr[1];
        for (int i = 1; i <= n; i++) {
            mx = Math.max(mx, pfx[i] - mn);
            mn = Math.min(mn, pfx[i]);
        }
        pw.println(mx);
        pw.close();
    }
}