import java.io.*;
import java.util.*;

public class WeGotEverythingCovered {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                          'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                          'w', 'x', 'y', 'z'};
        int t = Integer.parseInt(r.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = "";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    s += letters[j];
                }
            }
            pw.println(s);
        }
        pw.close();
    }
}