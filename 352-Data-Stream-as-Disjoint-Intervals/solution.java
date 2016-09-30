/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    
    private int binarySearch(int val, List<Interval> list, int left, int right) {
        if(left > right) return -1;
        if(left == right) {
            if(list.get(left).start > val) return left - 1;
            else return left;
        }
        int mid = left + (right - left) / 2;
        if(list.get(mid).start >= val) return binarySearch(val, list, left, mid);
        else return binarySearch(val, list, mid + 1, right);
    }
    List<Interval> list;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        list = new ArrayList<Interval>();
    }
    
    public void addNum(int val) {
        if(list.size() == 0) {
            Interval interval = new Interval(val, val);
            list.add(interval);
            return;
        }
        int index = binarySearch(val, list, 0, list.size() - 1);
        if(index == -1) {
            if(list.get(0).start == val + 1) {
                list.get(0).start = val;
                // int end = list.get(0).end;
                // Interval interval = new Interval(val, end);
                // list.remove(0);
                // list.add(0, interval);
            }
            else {
                Interval interval = new Interval(val, val);
                list.add(0, interval);
            }
        }
        else {
            if(list.get(index).end >= val)return;
            else if(list.get(index).end < val- 1 && (index == list.size() - 1 || list.get(index + 1).start > val + 1)) {
                Interval interval = new Interval(val, val);
                list.add(index + 1, interval);
            }
            else if(list.get(index).end == val- 1 && (index == list.size() - 1 || list.get(index + 1).start > val + 1)) {
                list.get(index).end++;
            }
            else if(list.get(index).end < val- 1 && (index < list.size() - 1 && list.get(index + 1).start == val + 1)) {
                list.get(index + 1).start--;
            }
            else if(list.get(index).end == val- 1 && (index < list.size() - 1 && list.get(index + 1).start == val + 1)) {
                int start = list.get(index).start;
                list.remove(index);
                list.get(index).start = start;
            }
        }
    }
    
    public List<Interval> getIntervals() {
        return list;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */