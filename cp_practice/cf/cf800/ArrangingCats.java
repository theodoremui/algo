import java.io.*;

public class ArrangingCats {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(r.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(r.readLine());
            char[] start = r.readLine().toCharArray();
            char[] want = r.readLine().toCharArray();
            int addOps = 0;
            int removeOps = 0;
            for (int i = 0; i < n; i++) {
                if (start[i] == '0' && want[i] == '1') { addOps++; }
                else if (start[i] == '1' && want[i] == '0') { removeOps++; }
            }
            pw.println(Math.max(addOps, removeOps));
        }
        pw.close();
    }
}