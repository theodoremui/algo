import java.io.*;

public class HPS {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pw = new PrintWriter("hps.out");
        
        int N = Integer.parseInt(r.readLine());
        int[] hoof = new int[N + 1];
        int[] paper = new int[N + 1];
        int[] scissors = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            hoof[i] = hoof[i - 1];
            paper[i] = paper[i - 1];
            scissors[i] = scissors[i - 1];
            char c = r.readLine().charAt(0);
            if (c == 'H') {
                hoof[i]++;
            }
            if (c == 'P') {
                paper[i]++;
            }
            if (c == 'S') {
                scissors[i]++;
            }
        }
        int maxWins = 0;
        for (int i = 1; i <= N; i++) {
            int beforeWins = Math.max(hoof[i], Math.max(paper[i], scissors[i]));
            int afterWins = Math.max(hoof[N] - hoof[i], Math.max(paper[N] - paper[i], scissors[N] - scissors[i]));
            maxWins = Math.max(maxWins, beforeWins + afterWins);
        }
        pw.println(maxWins);

        pw.close();
    }
}