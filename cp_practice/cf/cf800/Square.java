import java.io.*;
import java.util.*;

public class Square {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(r.readLine());
        while (t-- > 0) {
            ArrayList<int[]> coords = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(r.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                coords.add(new int[] {x, y});
            }
            coords.sort(Comparator.comparingInt(x -> x[1]));
            coords.sort(Comparator.comparingInt(x -> x[0]));
            pw.println((coords.get(1)[1] - coords.get(0)[1]) * (coords.get(2)[0] - coords.get(1)[0]));
        }
        pw.close();
    }
}