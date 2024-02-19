import java.io.*;

public class SwapAndDelete {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(r.readLine());
        while (t-- > 0) {
            String s = r.readLine();
            int[] cnt = new int[2];
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - '0']++;
            }
            for (int i = 0; i < s.length() + 1; i++) {
                if (i == s.length() || cnt[1 - (s.charAt(i) - '0')] == 0) {
                    pw.println(s.length() - i);
                    break;
                }
                cnt[1 - (s.charAt(i) - '0')]--;
            }
        }
        pw.close();
    }
}