import java.io.*;
import java.util.*;

public class MaxCross {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("maxcross.in"));
        PrintWriter pw = new PrintWriter("maxcross.out");
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] road = new int[N + 1];
        for (int i = 0; i < B; i++) {
            int id = Integer.parseInt(r.readLine());
            road[id]++;
        }

        int[] pfx = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            pfx[i] = pfx[i - 1] + road[i];
        }

        int ans = B;
        for (int i = 0; i <= N - K; i++) {
            ans = Math.min(ans, pfx[i + K] - pfx[i]);
        }

        pw.println(ans);
        pw.close();
    }
}