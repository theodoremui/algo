import java.io.*;
import java.util.*;

public class UnnaturalLanguageProcessing {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(r.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(r.readLine());
            String s = r.readLine();
            String[] word = new String[n];
            for (int i = 0; i < n; i++) {
                word[i] = s.substring(i, i + 1);
            }
            int idx = n - 1;
            while (idx > 0) {
                if (word[idx].equals("a") || word[idx].equals("e")) {
                    idx -= 2;
                } else {
                    idx -= 3;
                }
                if (idx > 0) {
                    word[idx + 1] = "." + word[idx + 1];
                }
            }
            for (int i = 0; i < n; i++) {
                pw.print(word[i]);
            }
            pw.println();
        }
        pw.close();
    }
}