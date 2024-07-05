import java.io.*;
import java.util.*;

public class GCD {

    static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());
        long[] a = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        long[] p = new long[N + 1];
        long[] s = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = gcd(p[i - 1], a[i - 1]);
        }
        for (int i = N - 1; i >= 0; i--) {
            s[i] = gcd(s[i + 1], a[i]);
        }
        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, gcd(p[i], s[i + 1]));
        }
        pw.println(ans);

        pw.close();
    }
}
