import java.io.*;
import java.util.*;

public class SatisfyingConstraints {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(r.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(r.readLine());
            int[][] constraints = new int[n][2];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(r.readLine());
                int a = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                constraints[i][0] = a;
                constraints[i][1] = x;
            }
            int mx = (int)1e9, mn = 0;
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (constraints[i][0] == 1) {
                    mn = Math.max(mn, constraints[i][1]);
                }
                if (constraints[i][0] == 2) {
                    mx = Math.min(mx, constraints[i][1]);
                }
                if (constraints[i][0] == 3){
                    a.add(constraints[i][1]);
                }
            }
            int cnt = 0;
            for (int ele : a) {
                if (ele >= mn && ele <= mx) {
                    cnt++;
                }
            }
            pw.println(Math.max(mx - mn + 1 - cnt, 0));
        }
        pw.close();
    }
}