import java.io.*;
import java.util.*;

public class FJActuallyFarms {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(r.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(r.readLine());
            long[] heights = new long[n];
            long[] grow = new long[n];
            long[] want = new long[n];
            StringTokenizer st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++) {
                heights[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++) {
                grow[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++) {
                want[i] = Long.parseLong(st.nextToken());
            }
            ArrayList<long[]> plants = new ArrayList<long[]>();
            for (int i = 0; i < n; i++) {
                plants.add(new long[] {heights[i], grow[i], want[i]});
            }
            boolean ok = true;
            long ans = 0;
            plants.sort(Comparator.comparingLong(p -> p[2]));
            for (int i = 1; i < n; i++) {
                long h1 = plants.get(i - 1)[0];
                long h2 = plants.get(i)[0];
                long a1 = plants.get(i - 1)[1];
                long a2 = plants.get(i)[1];
                if (h1 <= h2) {
                    if (a1 <= a2) {
                        ok = false;
                        break;
                    }
                    ans = Math.max(ans, (h2 - h1) / (a1 - a2) + 1);
                }
            }
            for (int i = 0; i < n; i++) {
                plants.set(i, new long[] {plants.get(i)[0] + plants.get(i)[1] * ans,
                                          plants.get(i)[1], plants.get(i)[2]});
            }
            for (int i = 1; i < n; i++) {
                long h1 = plants.get(i - 1)[0];
                long h2 = plants.get(i)[0];
                if (h1 <= h2) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                pw.println(ans);
            } else {
                pw.println(-1);
            }
        }
        pw.close();
    }
}