public class Solution {
    class Numpos {
        int number;
        int pos;
        Numpos(int number, int pos){
            this.number = number;
            this.pos = pos;
        }
        Numpos(Numpos another) {
            this.number = another.number;
            this.pos = another.pos;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        if(nums.length == 0)return new ArrayList<Integer>();
        Numpos[] cnum = new Numpos[nums.length];
        for(int i = 0; i < nums.length; i++) {
            cnum[i] = new Numpos(nums[i], i);
        }
        int[] smaller = new int[nums.length];
        //int[] ans = new int[nums.length];
        cnum = mergeSort(smaller, cnum);
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            list.add(smaller[i]);
        }
        return list;
    }
    
    private Numpos[] mergeSort(int[] smaller, Numpos[] numPos) {
        int half = numPos.length / 2;
        if(half > 0) {
            Numpos[] rightPart = new Numpos[numPos.length - half];
    		Numpos[] leftPart = new Numpos[half];
    		for (int i = 0; i < leftPart.length; i++) {
    			leftPart[i] = new Numpos(numPos[i]);
    		}
    		for (int i = 0; i < rightPart.length; i++) {
    			rightPart[i] = new Numpos(numPos[half + i]);
    		}
    		Numpos[] left = mergeSort(smaller, leftPart);
    		Numpos[] right = mergeSort(smaller, rightPart);
    		int m = left.length, n = right.length, i = 0, j = 0;
    		while (i < m || j < n) {
    			if (j == n || i < m && left[i].number <= right[j].number) {
    				numPos[i + j] = left[i];
    				smaller[left[i].pos] += j;
    				i++;
    			} else {
    				numPos[i + j] = right[j];
    				j++;
    			}
    		}
        }
        return numPos;
    }
}