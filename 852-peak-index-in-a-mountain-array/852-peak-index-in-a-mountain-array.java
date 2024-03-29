class Solution {
    public int peakIndexInMountainArray(int[] arr) {
     
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if((mid == 0 || arr[mid-1] < arr[mid]) && (mid == arr.length - 1 || arr[mid] > arr[mid+1])) {
                return mid;
            }
            
            if((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid] < arr[mid+1]) ) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;    
    }
}