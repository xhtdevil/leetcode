public class NumArray {
    
    public class SegmentedTree {
        int start;
        int end;
        int sum;
        SegmentedTree left, right;
        SegmentedTree(int start, int end) {
            
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.right = null;
            this.left = null;
            
        }
    }
    
    private SegmentedTree buildTree(int[] nums, int start, int end) {
        
        if(start > end)return null;
        SegmentedTree root = new SegmentedTree(start, end);
        if(start == end) {
            root.sum = nums[start];
        }
        if(start < end) {
            
            int mid = start + (end - start) / 2;
            root.left = buildTree(nums, start, mid);
            root.right = buildTree(nums, mid + 1, end);
            root.sum = root.left.sum + root.right.sum;
            
        }
        
        return root;
    }
    
    SegmentedTree root;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    void update(int i, int val) {
        update(root, i, val);
    }
    
    void update(SegmentedTree root, int i, int val) {
        if(root.start == root.end && i == root.start) root.sum = val;
        else if(root.start > root.end) return;
        else {
            
            int mid = root.start + (root.end - root.start) / 2;
            if(i <= mid)update(root.left, i, val);
            else if( i > mid)update(root.right, i, val);
             root.sum = root.right.sum + root.left.sum;
        }
       
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
        
    }
    
    public int sumRange(SegmentedTree root, int i, int j) {
        if(i == root.start && j == root.end) {
            return root.sum;
        }
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if(mid < i)return sumRange(root.right, i, j);
            if(mid >= j)return sumRange(root.left, i, j);
            else {
                return sumRange(root.left, i, mid) + sumRange(root.right, mid, j);
            }
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);