package Greedy;

import java.util.Arrays;
import java.util.List;

class Activity implements Comparable<Activity> {
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Activity a) {
        if (this.end == a.end)
            return a.end - this.end;
        return this.end - a.end;
    }

}

public class ActivitySelection {
    public int activitySelection(List<Integer> start, List<Integer> end) {
        int n = start.size();
        Activity[] arr = new Activity[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Activity(start.get(i), end.get(i));
        }

        Arrays.sort(arr);
        int cnt = 1;
        int i = 0, j = 1;
        while (j < n) {
            if (arr[i].end < arr[j].start) {
                i = j;
                cnt++;
            }
            j++;
        }
        return cnt;
    }
}
