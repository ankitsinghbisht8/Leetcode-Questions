class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            freeRooms.add(i);
        }
        PriorityQueue<long[]> busyRooms=new PriorityQueue<>((a,b)->a[0]==b[0] ? (int)(a[1]-b[1]):(a[0]<b[0]? -1:1));
        
        int[] count=new int[n];

        for(int[] meet:meetings){
            long start=meet[0];
            long end=meet[1];
            long duration=end-start;

            while(!busyRooms.isEmpty() && busyRooms.peek()[0]<=start){
                freeRooms.add((int) busyRooms.poll()[1]);
            }

            if(!freeRooms.isEmpty()){
                int room=freeRooms.poll();
                count[room]++;
                busyRooms.add(new long[]{end,room});
            }
            else{
               long[] earliest=busyRooms.poll();
               long newEnd=earliest[0] + duration;
               int room=(int) earliest[1];

               count[room]++;
               busyRooms.add(new long[] {newEnd,room});
            }
        }


        int ans=0;
        for(int i=1;i<n;i++){
            if(count[i]>count[ans]){
                ans=i;
            }
        }
        
        return ans;
    }
}