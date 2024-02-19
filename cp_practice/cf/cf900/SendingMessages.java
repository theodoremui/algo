import java.io.*;
import java.util.*;

public class SendingMessages {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(r.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            int[] m = new int[n + 1];
            st = new StringTokenizer(r.readLine());
            for (int i = 1; i <= n; i++) {
                m[i] = Integer.parseInt(st.nextToken());
            }
            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                f -= Math.min((m[i] - m[i - 1]) * a, b);
                if (f <= 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }
        pw.close();
    }
}