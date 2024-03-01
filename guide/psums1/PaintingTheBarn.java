import java.io.*;
import java.util.*;

public class PaintingTheBarn {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("paintbarn.in"));
        PrintWriter pw = new PrintWriter("paintbarn.out");
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] grid = new int[1001][1001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(r.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                grid[j][y1]++;
                grid[j][y2]--;
            }
        }
        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (grid[i][j] == K) {
                    ans++;
                }
                grid[i][j + 1] += grid[i][j];
            }
        }

        pw.println(ans);
        pw.close();
    }
}