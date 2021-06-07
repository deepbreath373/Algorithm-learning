import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k){
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public int[] getLeastNumbers2(int[] arr, int k){
        if(k==0 || arr.length==0){
            return new int[0];
        }
        return quickSearch(arr,0,arr.length-1,k-1);
    }
    private int[] quickSearch(int[] arr, int lo, int hi, int k) {
        int j = partiton(arr,lo,hi);
        if(j==k){
            return Arrays.copyOf(arr,j+1);
        }
        return j > k ? quickSearch(arr,lo,j-1,k) : quickSearch(arr,j+1,hi,k);
    }
    private int partiton(int[] arr, int lo, int hi) {
        int v = arr[lo];
        int i = lo, j = hi + 1;
        while(true){
            while(++i <= hi && arr[i] < v);
            while(--j >= lo && arr[j] > v);
            if(i >= j){
                break;
            }
            int t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
        }
        arr[lo] = arr[j];
        arr[j] = v;
        return j;
    }

    //利用大根堆
    public int[] getLeastNumbers3(int[] arr, int k){
        if(k==0 || arr.length==0){
            return new int[0];
        }
        Queue<Integer> pq = new PriorityQueue<>((v1,v2)->v2-v1);
        for (int num : arr) {
            if(pq.size() < k){
                pq.offer(num);
            }else if(num < pq.peek()){
                pq.poll();
                pq.offer(num);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }
}
