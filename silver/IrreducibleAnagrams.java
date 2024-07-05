import java.io.*;
import java.util.*;

public class IrreducibleAnagrams {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String s = br.readLine();
        int n = s.length();
        int[][] letters = new int[n + 1][26];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 26; j++) {
                letters[i][j] = letters[i - 1][j];
            }
            letters[i][s.charAt(i - 1) - 'a']++;
        }
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = 0; j < 26; j++) {
                if (letters[r][j] - letters[l - 1][j] > 0) {
                    count++;
                }
            }
            if (l == r || s.charAt(l - 1) != s.charAt(r - 1) || count >= 3) {
                pw.println("Yes");
            } else {
                pw.println("No");
            }
        }

        pw.close();
    }
}
