import java.io.*;
import java.util.*;

public class GoodSubarrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.valueOf(s.substring(i - 1, i));
            }
            int[] p = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = p[i - 1] + a[i];
            }
            HashMap<Integer, Integer> mp = new HashMap<>();
            for (int i = 0; i <= n; i++) {
                if (mp.containsKey(p[i] - i)) {
                    mp.put(p[i] - i, mp.get(p[i] - i) + 1);
                } else {
                    mp.put(p[i] - i, 1);
                }
            }
            long ans = 0;
            for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                long val = entry.getValue();
                ans += val * (val - 1) / 2;
            }
            pw.println(ans);
        }

        pw.close();
    }
}