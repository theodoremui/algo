import java.io.*;
import java.util.*;

public class Helmets {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(r.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int[] b = new int[n];
            st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            if (n == 1) {
                pw.println(p);
            } else {
                ArrayList<int[]> residents = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    residents.add(new int[] {a[i], b[i]});
                }
                residents.sort(Comparator.comparingInt(o -> o[0]));
                residents.sort(Comparator.comparingInt(o -> o[1]));
                int sum = 0;
                int idx = 0;
                int cnt = 0;
                while (idx < n && sum < n - 1) {
                    sum += residents.get(idx)[0];
                    cnt++;
                    idx++;
                }
                int ans = p * cnt;
                int total = cnt;
                for (int i = 0; i < cnt; i++) {
                    ans += residents.get(i)[0] * residents.get(i)[1];
                    total += residents.get(i)[0];
                    if (total >= n) {
                        break;
                    }
                }
                pw.println(ans);
            }
        }
        pw.close();
    }
}