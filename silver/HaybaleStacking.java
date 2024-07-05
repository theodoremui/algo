import java.io.*;
import java.util.*;

public class HaybaleStacking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] changes = new long[N + 2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            changes[start]++;
            changes[end + 1]--;
        }
        long count = 0;
        long[] bales = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            count += changes[i];
            bales[i] += count;
        }
        Arrays.sort(bales);

        pw.println(bales[N / 2 + 1]);
        pw.close();
    }
}
