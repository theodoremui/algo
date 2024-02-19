import java.io.*;
import java.util.*;

public class MovieFestivalII {
    static TreeMap<Integer, Integer> multiset = new TreeMap<Integer, Integer>();

    static class Event implements Comparable<Event> {
        public int start, end;
        public Event (int s, int e) {
            start = s;
            end = e;
        }
        public int compareTo(Event other) {
            return end - other.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Event[] events = new Event[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(r.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            events[i] = new Event(start, end);
        }
        for (int i = 0; i < k; i++) {
            add(0);
        }
        Arrays.sort(events);
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (multiset.floorKey(events[i].start) != null) {
                remove(multiset.floorKey(events[i].start));
                add(events[i].end);
                count++;
            }
        }
        pw.println(count);
        pw.close();
    }

    static void add (int x) {
        if (multiset.containsKey(x)) {
            multiset.put(x, multiset.get(x) + 1);
        } else {
            multiset.put(x, 1);
        }
    }

    static void remove (int x) {
        multiset.put(x, multiset.get(x) - 1);
        if (multiset.get(x) == 0) {
            multiset.remove(x);
        }
    }
}