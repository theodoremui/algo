import java.io.*;
import java.util.*;

public class MovieFestival {
    static class Movie implements Comparable<Movie> {
        public int start, end;
        public Movie(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int compareTo(Movie other) {
            return end - other.end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = Integer.parseInt(r.readLine());
        Movie[] movies = new Movie[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            movies[i] = new Movie(a, b);
        }
        Arrays.sort(movies);
        int ans = 1;
        int prevEnd = movies[0].end;
        for(Movie movie : movies) {
            if(movie.start >= prevEnd) {
                ans++;
                prevEnd = movie.end;
            }
        }
        pw.println(ans);
        pw.close();
    }
}