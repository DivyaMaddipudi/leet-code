class Solution {
    public int minEatingSpeed(int[] piles, int h) { 
        int low = 1;
        int high = Integer.MIN_VALUE;
        
        for(int i=0;i<piles.length;i++) {
            if(piles[i] > high) {
                high = piles[i];
            }
        }
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            int time = 0;
           for(int pile : piles) {
               time += pile/mid;
               if(pile%mid != 0) {
                   time++;
               }
           }
          
            if(time <= h && time > 0) {
                high = mid-1;
            } else {
                low = mid+1;
            } 
        }
        return low;
    }
}