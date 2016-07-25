public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaSum = (D - B) * (C - A) + (H - F) * (G - E);
        int overlaph = 0, overlapw = 0;
         if(D <= F || B >= H){overlaph = 0;}
        else if(B <= F && D >= H){overlaph = H - F;}
        else if(B >= F && D >= H){overlaph = H - B;}
        else if(B >= F && D <= H){overlaph = D - B;}
        else if(B <= F && D <= H){overlaph = D - F;}
       // else if(D <= F || B >= H){overlaph = 0;}
       if(C <= E || A >= G){overlapw = 0;}
        else if(A <= E && C >= G){overlapw = G - E;}
        else if(A >= E && C >= G){overlapw = G - A;}
        else if(A >= E && C <= G){overlapw = C - A;}
        else if(A <= E && C <= G){overlapw = C - E;}
      //  else if(C <= E || A >= G){overlapw = 0;}
        int overlapArea = overlaph * overlapw;
        //int[] a = new int[3];
        int[] a = {overlaph,overlapw,areaSum - overlapArea};
        return a[2];
    }
}