public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n < k || k <= 0) {
            return new int[0];
        }
        int[] ans = new int[n - k + 1];
        
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            if(!q.isEmpty() && q.peek() <= i - k) {
                q.poll();
            }
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if(i >= k - 1) {
                ans[ri++] = nums[q.peek()];
            }
            
        }
        
        return ans;
    }
}