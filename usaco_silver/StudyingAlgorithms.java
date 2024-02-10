import java.io.*;
import java.util.*;

public class StudyingAlgorithms {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] a = new int[N];
        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int cnt = 0;
        Arrays.sort(a);
        for(int i = 0; i < N; i++){
            if(sum + a[i] > X) break;
            sum += a[i];
            cnt++;
        }
        pw.println(cnt);
        pw.close();
    }
}