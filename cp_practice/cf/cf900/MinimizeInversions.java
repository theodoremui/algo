import java.io.*;
import java.util.*;

public class MinimizeInversions {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(r.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(r.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            StringTokenizer st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<int[]> pairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                pairs.add(new int[] {a[i], b[i]});
            }
            pairs.sort(Comparator.comparingInt(j -> j[0]));
            for (int i = 0; i < n; i++) {
                pw.print(pairs.get(i)[0] + " ");
            }
            pw.println();
            for (int i = 0; i < n; i++) {
                pw.print(pairs.get(i)[1] + " ");
            }
            pw.println();
        }
        pw.close();
    }
}