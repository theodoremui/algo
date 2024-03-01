import java.io.*;
import java.util.*;

public class GCDOnBlackboard {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int N = Integer.parseInt(r.readLine());
        long[] A = new long[N];

        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        long[] pfx = new long[N + 1];
        long[] sfx = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            pfx[i] = gcd(pfx[i - 1], A[i - 1]);
        }

        for (int i = N - 1; i >= 0; i--) {
            sfx[i] = gcd(sfx[i + 1], A[i]);
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, gcd(pfx[i], sfx[i + 1]));
        }

        pw.println(ans);
        pw.close();
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}