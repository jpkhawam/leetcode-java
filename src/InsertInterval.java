/// https://leetcode.com/problems/insert-interval
void main() {
}

public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int i = 0;

    // place all the intervals at the beginning that don't overlap
    while (i < intervals.length
            && intervals[i][1] < newInterval[0]) {
        result.add(intervals[i]);
        i++;
    }

    // start of potential overlaps
    while (i < intervals.length
            && // for it to overlap it does not end before interval starts
            intervals[i][1] >= newInterval[0]
            && // still overlaps: doesn't start after the end of newInterval
            !(intervals[i][0] > newInterval[1])) {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }

    result.add(newInterval);

    while (i < intervals.length) {
        result.add(intervals[i]);
        i++;
    }

    return result.toArray(new int[0][0]);
}
