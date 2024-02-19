import java.io.*;
import java.util.*;

public class Sevens {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("div7.in"));
        PrintWriter pw = new PrintWriter("div7.out");
        
        int n = Integer.parseInt(r.readLine());
        int[] pfx = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int id = Integer.parseInt(r.readLine());
            pfx[i] = (pfx[i - 1] + id) % 7;
        }
        int[] mods = new int[7];
        Arrays.fill(mods, Integer.MAX_VALUE);
        int mx = 0;
        for (int i = 1; i <= n; i++) {
            mx = Math.max(mx, i - mods[pfx[i]]);
            mods[pfx[i]] = Math.min(mods[pfx[i]], i);
        }
        pw.println(mx);
        pw.close();
    }
}