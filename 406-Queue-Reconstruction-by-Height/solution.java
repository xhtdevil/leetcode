public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> arranged = new ArrayList<int[]>();
        int[][] ans = new int[people.length][2];
        PriorityQueue<int[]> waiting = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2) {
                if(i2[0] != i1[0])return i2[0] - i1[0];
                else return i1[1] - i2[1];
            }
        });
        for(int i = 0; i < people.length; i++) {
            waiting.offer(people[i]);
        }
        while(!waiting.isEmpty()) {
            int[] tall = waiting.poll();
            arranged.add(tall[1], tall);
        }
        for(int i = 0; i < people.length; i++) {
            ans[i] = arranged.get(i);
        }
        return ans;
    }
}