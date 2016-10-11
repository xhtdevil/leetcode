/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    class Slope {
     int x;
     int y;
     Slope(int a,int b){x = a; y = b;}
 } 
    public int maxPoints(Point[] points) {
        if(points.length <= 2)return points.length;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        int result = 0;
        for(int i = 0; i < points.length; i++) {
            map.clear();
            int max = 1;
            int overlap = 0;
            for(int j = i + 1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if(x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                
                int gcd = gcd(x, y);

                x = x / gcd;
                y = y / gcd;

                //Slope slope = new Slope(x, y);
                if(map.containsKey(x)) {
                    if(map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                        
                    }
                    else {
                        map.get(x).put(y, 2);
                    }
                }
                else {
                    Map<Integer, Integer> mapsub = new HashMap<Integer, Integer>();
                    mapsub.put(y, 2);
                    map.put(x, mapsub);
                }
                max = Math.max(max, map.get(x).get(y)); //max point line with point i;
            }
            result = Math.max(result, max + overlap);         //total max point line
        }
        return result;
    }
    
    private int gcd(int x, int y) {
        if(y == 0)return x;
        else return gcd(y, x % y);
    }
}