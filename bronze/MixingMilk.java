import java.io.*;
import java.util.*;

public class MixingMilk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter pw = new PrintWriter("mixmilk.out");

        int[] cap = new int[3];
        int[] amt = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cap[i] = Integer.parseInt(st.nextToken());
            amt[i] = Integer.parseInt(st.nextToken());
        }

        int curr = 0;
        for (int pour = 1; pour <= 100; pour++) {
            int next = (curr + 1) % 3;
            if (amt[curr] + amt[next] > cap[next]) {
                amt[curr] = Math.max(0, amt[curr] - (cap[next] - amt[next]));
                amt[next] = cap[next];
            } else {
                amt[next] += amt[curr];
                amt[curr] = 0;
            }
            curr = (curr + 1) % 3;
        }

        for (int i = 0; i < 3; i++) {
            pw.println(amt[i]);
        }

        pw.close();
    }
}