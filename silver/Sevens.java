import java.io.*;
import java.util.*;

public class Sevens {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("div7.in"));
        PrintWriter pw = new PrintWriter("div7.out");

        int N = Integer.parseInt(br.readLine());
        int[] cows = new int[N + 1];
        int[] p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cows[i] = Integer.parseInt(br.readLine());
            p[i] = (p[i - 1] + cows[i]) % 7;
        }
        int[] mods = new int[7];
        Arrays.fill(mods, -1);
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (mods[p[i]] != -1) {
                ans = Math.max(ans, i - mods[p[i]]);
            } else {
                mods[p[i]] = i;
            }
        }

        pw.println(ans);
        pw.close();
    }
}
