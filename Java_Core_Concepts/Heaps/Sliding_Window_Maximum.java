import java.util.PriorityQueue;

public class Sliding_Window_Maximum {

    static class Pair implements Comparable<Pair>{
        int value;
        int idx;
        Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
        @Override
        public int compareTo(Pair p2){
            //ascending 
            // return p2.value-this.value;
            //but we need descending order
            return p2.value-this.value; // For max heap, we want larger values to come first
        }
    }
    
    public static void main(String[] args) {
        int arr[]={1, 3, -1, -3, 5, 3, 6, 7};
        int k=3;
        int res[]=new int [arr.length - k + 1];//n-k+1 because we need to store the maximum of each sliding window of size k
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i],i));
        }
        res[0]=pq.peek().value;
        for(int i=k;i<arr.length;i++){
             while(pq.size()>0 && pq.peek().idx<=(i-k)){// Remove elements that are out of the current window
                 // If the index of the top element is less than or equal to i-k, it means it's out of the current window
                pq.remove();
             }

             pq.add(new Pair(arr[i],i));
             res[i-k+1]=pq.peek().value;// Store the maximum of the current window
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }
}
