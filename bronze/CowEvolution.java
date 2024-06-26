import java.io.*;
import java.util.*;

public class CowEvolution {

    static int N;
    static ArrayList<String>[] cows;
    static ArrayList<String> traits;

    static boolean ok() {
        for (int i = 0; i < traits.size(); i++) {
            for (int j = i + 1; j < traits.size(); j++) {
                boolean case1 = false;
                boolean case2 = false;
                boolean case3 = false;
                for (int x = 0; x < N; x++) {
                    if (cows[x].contains(traits.get(i)) && !cows[x].contains(traits.get(j))) {
                        case1 = true;
                    } else if (cows[x].contains(traits.get(j)) && !cows[x].contains(traits.get(i))) {
                        case2 = true;
                    } else if (cows[x].contains(traits.get(i)) && cows[x].contains(traits.get(j))) {
                        case3 = true;
                    }
                }
                if (case1 && case2 && case3) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("evolution.in"));
        PrintWriter pw = new PrintWriter("evolution.out");

        N = Integer.parseInt(br.readLine());
        cows = new ArrayList[N];
        traits = new ArrayList<String>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            cows[i] = new ArrayList<String>();
            for (int j = 0; j < K; j++) {
                String trait = st.nextToken();
                cows[i].add(trait);
                if (!traits.contains(trait)) {
                    traits.add(trait);
                }
            }
        }

        if (ok()) {
            pw.println("yes");
        } else {
            pw.println("no");
        }

        pw.close();
    }
}
