import java.io.*;
import java.util.*;

public class RunningMiles {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(r.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(r.readLine());
            int[] b = new int[n];
            StringTokenizer st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            int[] pmax = new int[n];
            int[] smax = new int[n];
            for (int i = 0; i < n; i++) {
                pmax[i] = b[i] + i;
                smax[i] = b[i] - i;
            }
            for (int i = 1; i < n; i++) {
                pmax[i] = Math.max(pmax[i], pmax[i - 1]);
            }
            for (int i = n - 2; i >= 0; i--) {
                smax[i] = Math.max(smax[i], smax[i + 1]);
            }
            int ans = 0;
            for (int i = 1; i < n - 1; i++) {
                ans = Math.max(ans, pmax[i - 1] + b[i] + smax[i + 1]);
            }
            pw.println(ans);
        }

        pw.close();
    }
}