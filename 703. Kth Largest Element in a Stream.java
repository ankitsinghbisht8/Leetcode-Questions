// Approach 1
class KthLargest {
    List <Integer> stream;
    int k;

    public KthLargest(int k, int[] nums) {
        stream =new ArrayList<Integer>(nums.length);
        this.k=k;

        for(int num:nums){
            stream.add(num);
        }
        Collections.sort(stream);
        
    }
    
    public int add(int val) {
        int index=getIndex(val);
        
        stream.add(index, val);
        return stream.get(stream.size() - k);
        }

        private int getIndex(int val){
        int left=0;
        int right=stream.size()-1;
        while(left<=right){
            int mid= (left + right)/2;
            int midElement= stream.get(mid);

            if(midElement == val) return mid;
            if(midElement > val){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

// Approach 2: Heap

class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            minHeap.add(num);
            // If heap has more than k elements, evict the smallest element
            // aka the top element.
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
    }

    public int add(int val) {
        // Add to our minHeap if we haven't processed k elements yet
        // or if val is greater than the top element (the k-th largest)
        if (minHeap.size() < k || minHeap.peek() < val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}
