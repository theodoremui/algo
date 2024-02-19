import java.io.*;

public class TrickyTemplate {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(r.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(r.readLine());
            char[] a = r.readLine().toCharArray();
            char[] b = r.readLine().toCharArray();
            char[] c = r.readLine().toCharArray();
            if (check(a, b, c)) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }
        pw.close();
    }

    static boolean check(char[] a, char[] b, char[] c) {
        for (int i = 0; i < n; i++) {
            if (a[i] != c[i] && b[i] != c[i]) {
                return true;
            }
        }
        return false;
    }
}