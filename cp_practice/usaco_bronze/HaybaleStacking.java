import java.io.*;
import java.util.*;

public class HaybaleStacking {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] diffs = new int[N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(r.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            diffs[A - 1]++;
            diffs[B]--;
        }
        int[] bales = new int[N + 1];
        for (int i = 1; i <= N; i++) {
             bales[i] = bales[i - 1] + diffs[i - 1];
        }
        Arrays.sort(bales);
        pw.println(bales[N / 2 + 1]);
        pw.close();
    }
}