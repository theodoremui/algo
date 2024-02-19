import java.io.*;
import java.util.*;

public class CowntactTracing2 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = Integer.parseInt(r.readLine());
        String cows = r.readLine();
        ArrayList<Integer> intervals = new ArrayList<Integer>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cows.charAt(i) == '0' && cnt > 0) {
                intervals.add(cnt);
                cnt = 0;
            } else if (cows.charAt(i) == '1') {
                cnt++;
            }
        }
        if (cnt > 0) {
            intervals.add(cnt);
        }
        int l = intervals.size();
        if (l == 0) {
            pw.println(0);
        } else {
            int maxDays = Math.min(intervals.get(0), intervals.get(l - 1)) - 1;
            boolean leftZero = cows.charAt(0) == '0';
            boolean rightZero = cows.charAt(n - 1) == '0';
            if (leftZero) {
                maxDays = Math.min(maxDays, (intervals.get(0) - 1) / 2);
            }
            if (rightZero) {
                maxDays = Math.min(maxDays, (intervals.get(l - 1) - 1) / 2);
            }
            for (int i = 1; i < l - 1; i++) {
                maxDays = Math.min(maxDays, (intervals.get(i) - 1) / 2);
            }
            int ans = 0;
            for (int i = 0; i < l; i++) {
                ans += intervals.get(i) / (2 * maxDays + 1);
                if (intervals.get(i) % (2 * maxDays + 1) != 0) {
                    ans++;
                }
            }
            pw.println(ans);
        }
        pw.close();
    }
}