class Solution {
    public int trap(int[] height) {
        int l = 0; int n = height.length; int r = n - 1;
        int lmax = height[0]; int rmax = height[n - 1];
        int total = 0;

        while(l <= r){
            if(lmax <= rmax){
                if(height[l] < lmax)
                    total += (lmax - height[l]);
                else
                    lmax = height[l];
                
                l = l + 1;
            }
            else{
                if(height[r] < rmax)
                    total += (rmax - height[r]);
                else
                    rmax = height[r];

                r = r - 1;
            }
        }
        return total;
    }
}
