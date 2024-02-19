import java.io.*;
import java.util.*;

public class StaticRangeSum {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        long[] a = new long[N + 1];
        long[] psums = new long[N + 1];
        st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Long.parseLong(st.nextToken());
            psums[i] = a[i] + psums[i - 1];
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(r.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            pw.println(psums[right] - psums[left]);
        }
        pw.close();
    }
}