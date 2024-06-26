import java.io.*;
import java.util.*;

public class ShellGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter("shell.out");

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int[] b = new int[N];
        int[] g = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int shell = 1; shell <= 3; shell++) {
            int[] shells = new int[3];
            shells[shell - 1] = 1;
            int count = 0;

            for (int i = 0; i < N; i++) {
                int temp = shells[a[i] - 1];
                shells[a[i] - 1] = shells[b[i] - 1];
                shells[b[i] - 1] = temp;

                if (shells[g[i] - 1] == 1) {
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        pw.println(answer);
        pw.close();
    }
}