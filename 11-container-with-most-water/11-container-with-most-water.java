class Solution {
    public int maxArea(int[] height) {
        
        
        int area = 0;
        int l =0;
        int r = height.length - 1;
        while(l<r) {
           area = Math.max(area, (r-l) * Math.min(height[r], height[l])); 
            
           if(height[l] < height[r]) {
               l++; 
           } else {
               r--;
           }
        }
        return area;
    }
}