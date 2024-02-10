import java.io.*;
import java.util.*;

public class Tasks {
    static class Event implements Comparable<Event> {
        public int duration, deadline;
        public Event (int a, int d) {
            duration = a;
            deadline = d;
        }
        public int compareTo(Event other) {
            return duration - other.duration;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = Integer.parseInt(r.readLine());
        Event[] events = new Event[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            events[i] = new Event(a, d);
        }
        Arrays.sort(events);
        long time = 0;
        long reward = 0;
        for (int i = 0; i < n; i++) {
            time += events[i].duration;
            reward += events[i].deadline - time;
        }
        pw.println(reward);
        pw.close();
    }
}