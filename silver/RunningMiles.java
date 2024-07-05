import java.io.*;
import java.util.*;

public class RunningMiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] b = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            int[] left = new int[n];
            int[] right = new int[n];
            for (int i = 0; i < n; i++) {
                left[i] = b[i] + (i + 1);
                right[i] = b[i] - (i + 1);
            }
            int[] pfx = new int[n + 1];
            int[] sfx = new int[n + 1];
            pfx[0] = left[0];
            sfx[n] = right[n - 1];
            for (int i = 1; i <= n; i++) {
                pfx[i] = Math.max(pfx[i - 1], left[i - 1]);
            }
            for (int i = n - 1; i >= 0; i--) {
                sfx[i] = Math.max(sfx[i + 1], right[i]);
            }
            long ans = 0;
            for (int i = 1; i < n - 1; i++) {
                ans = Math.max(ans, b[i] + pfx[i] + sfx[i + 1]);
            }
            pw.println(ans);
        }

        pw.close();
    }
}
