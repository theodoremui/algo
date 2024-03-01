import java.io.*;
import java.util.*;

public class IrreducibleAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] sum = new int[s.length() + 1][26];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                sum[i][j] = sum[i - 1][j];
            }
            sum[i][s.charAt(i - 1) - 'a']++;
        }
        
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            String t = s.substring(l - 1, r);
            int cnt = 0;
            for (int j = 0; j < 26; j++) {
                if (sum[r][j] - sum[l - 1][j] > 0) {
                    cnt++;
                }
            }
            if (t.length() == 1 || t.charAt(0) != t.charAt(t.length() - 1) || cnt >= 3) {
                pw.println("Yes");
            } else {
                pw.println("No");
            }
        }

        pw.close();
    }
}