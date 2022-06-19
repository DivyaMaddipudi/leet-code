class Solution {
    public List<Integer> pancakeSort(int[] arr) {
     
        List<Integer> ans = new ArrayList<Integer>();
        int size = arr.length;
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i=0;i<size;i++) {
            max = Integer.MIN_VALUE;
            for(int j=0;j<size-i;j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    index = j;
                    // System.out.println(max);
                }
            }
            
            flip(arr, index);
            ans.add(index+1);
            
            flip(arr, arr.length-i-1);
            ans.add(arr.length-i);
            
            System.out.println(max + " " + index);
            
        }
        
        for(int j=0;j<arr.length;j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
        return ans;
    }
    
    public void flip(int[] arr, int k) {
        int[] copy = new int[k+1];
          
        // for(int j=0;j<arr.length;j++) {
        //     System.out.print(arr[j] + " ");
        // }
        
        System.out.println(k + " k value " + copy.length);
        for(int i=k;i>=0;i--) {
            copy[k-i] = arr[i];
        }
        
        for(int j=0;j<copy.length;j++) {
            arr[j] = copy[j];
            // System.out.print(arr[j] + " --- ");
        }
    }
}