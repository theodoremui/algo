import java.io.*;
import java.util.*;

public class ForestQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(r.readLine());
            String line = st.nextToken();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == '*') {
                    grid[i + 1][j + 1] = 1;
                }
            }
        }
        int[][] pfx = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                pfx[i][j] = pfx[i - 1][j] + pfx[i][j - 1] - pfx[i - 1][j - 1] + grid[i][j];
            }
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(r.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            pw.println(pfx[r2][c2] - pfx[r1 - 1][c2] - pfx[r2][c1 - 1] + pfx[r1 - 1][c1 - 1]);
        }
        pw.close();
    }
}