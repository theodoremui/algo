import java.io.*;
import java.util.*;

public class TwoOutOfThree {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(r.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(r.readLine());
            int[] a = new int[n];
            int[][] info = new int[101][2];
            StringTokenizer st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                info[a[i]][0]++;
                info[a[i]][1] = i;
            }
            int[] b = new int[n];
            Arrays.fill(b, 1);
            int k = 2;
            for (int i = 1; i <= 100; i++) {
                if (info[i][0] >= 2) {
                    b[info[i][1]] = k;
                    k++;
                    if (k > 3) {
                        break;
                    }
                }
            }
            if (k <= 3) {
                pw.println(-1);
            } else {
                for (int i = 0; i < n; i++) {
                    pw.print(b[i] + " ");
                }
                pw.println();
            }
        }
        pw.close();
    }
}