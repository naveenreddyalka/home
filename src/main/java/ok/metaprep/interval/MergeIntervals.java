package ok.metaprep.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Interval{
  int start;
  int end;
  boolean closed;
  public Interval(int start, int end)
  {
    this.start = start;
    this.end = end;
    this.closed = true; // by default, the interval is closed
  }

  // set the flag for closed/open
  public void setClosed(boolean closed)
  {
    this.closed = closed;
  }

}

public class MergeIntervals {

  public static void main(String[] args) {
    int step = 2;
    step *= 2;
    int[][] intervals = {{1, 5}, {3, 7}, {4, 6}};
    printIntervals(mergeIntervals(intervals));

    List<List<Interval>> schedule = new ArrayList<List<Interval>>();
    schedule.add(Arrays.asList(new Interval(1, 2), new Interval(6, 7)));
    schedule.add(Arrays.asList(new Interval(3, 4), new Interval(5, 10)));

    printIntervalList(employeeFreeTime2(schedule));
  }

  public static void printIntervalList(List<Interval> intervals) {
    for (Interval interval : intervals) {
      System.out.println("[" + interval.start + ", " + interval.end + "]");
    }
  }

  public static void printIntervals(int[][] intervals) {
    for (int i = 0; i < intervals.length; i++) {
      for (int j = 0; j < intervals[i].length; j++) {
        System.out.print(intervals[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static int[][] mergeIntervals(int[][] intervals) {
    // Replace this placeholder return statement with your code
    int n = intervals.length;

    if(n<=1) return intervals;
    List<int[]> result = new ArrayList<>();
    //result.add(intervals[0]);
    result.add(0, new int[]{intervals[0][0], intervals[0][1]});
    int lastIndex =0;


    for(int i=1;i<intervals.length;i++){
      if(result.get(lastIndex)[1]>intervals[i][0]){
        result.get(lastIndex)[1] = Math.max(intervals[i][1],result.get(lastIndex)[1]);
      }else{
        result.add(lastIndex+1, new int[]{intervals[i][0], intervals[i][1]});
        lastIndex++;
      }
    }

    return result.toArray(new int[][]{});
  }


  public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

    if(schedule==null || schedule.size()==0) return new ArrayList<>();

    List<Interval> combined = new ArrayList<>();

    for(List<Interval> in : schedule ){
      combined.addAll(in);
    }

    combined.sort((a,b)->a.start-b.start);

   List<Interval> merged = new ArrayList<>();
   merged.add(combined.get(0));
   int cur = 0;

    for(int i=1;i<combined.size();i++){

      if(merged.get(cur).end >= combined.get(i).start ){
         merged.get(cur).end = Math.max(merged.get(cur).end,combined.get(i).end);
      }else{
        cur++;
        merged.add(combined.get(i));
      }
    }

    List<Interval> ans = new ArrayList<Interval>();
    for(int i=0; i<merged.size()-1;i++) {
      ans.add(new Interval(merged.get(i).end, merged.get(i + 1).start));
    }

    return ans;
  }


  public static List<Interval> employeeFreeTime2(List<List<Interval>> schedule) {
    // This is min heap , smallest element on the top of the heap
    // natural order sort gives ascending or increasing order
    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    for (int i = 0; i < schedule.size(); i++) {
      List<Interval> employeeSchedule = schedule.get(i);
      Interval interval = employeeSchedule.get(0);
      heap.offer(new int[]{interval.start, i, 0});
    }

    List<Interval> result = new ArrayList<>();

    int previous = schedule.get(heap.peek()[1]).get(heap.peek()[2]).start;

    while (!heap.isEmpty()) {
      int[] tuple = heap.poll();
      int i = tuple[1];
      int j = tuple[2];

      Interval interval = schedule.get(i).get(j);

      if (interval.start > previous) {
        result.add(new Interval(previous, interval.start));
      }

      previous = Math.max(previous, interval.end);

      if (j + 1 < schedule.get(i).size()) {
        Interval nextInterval = schedule.get(i).get(j + 1);
        heap.offer(new int[]{nextInterval.start, i, j + 1});
      }
    }
    return result;
  }
}
